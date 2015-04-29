package it.unica.isw.ctm.validator;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.validator.exceptions.NoSuitableValidatorFoundException;
import it.unica.isw.ctm.validator.exceptions.NoVendorValidatorException;
import it.unica.isw.ctm.validator.exceptions.WrongValidatorKindException;
import it.unica.isw.ctm.validator.singleusetickets.SingleUseTicketValidatorCollector;

import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;


/**
 * Collector for {@link TicketValidator}.
 */
public class TicketValidatorCollector implements TicketValidator {

	private TicketValidatorCollector instance;
	private Collection<TicketValidator> validators;
	
	
	/**
	 * Default constructor.
	 */
	private TicketValidatorCollector() {
		validators = new Vector<TicketValidator>();
		
		validators.add(SingleUseTicketValidatorCollector.getInstance());		
	}
	
	
	public TicketValidatorCollector getInstance() {
		if (instance == null)
			instance = new TicketValidatorCollector();
		return instance;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Ticket ticket) throws NoSuitableValidatorFoundException {
		Iterator<TicketValidator> i = validators.iterator();
		
		while (i.hasNext()) {
			try{
				i.next().validate(ticket);
				return;
			} // Found validators for the ticket kind, but no suitable validators 
			catch (NoVendorValidatorException e) {
				throw new Exception("Vendor " + e.getTicket().getVendor() + " not found for " +
									TICKETS_KINDS.is(e.getTicket()).name());
			} // Wrong validator, switch to next 
			catch (WrongValidatorKindException e) {
				continue;
			}
		}
		
		throw new NoSuitableValidatorFoundException(ticket);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		return true;
	}

	
	
}
