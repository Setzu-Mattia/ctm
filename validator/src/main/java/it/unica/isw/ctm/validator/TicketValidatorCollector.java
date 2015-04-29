package it.unica.isw.ctm.validator;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.validator.exceptions.NoVendorValidatorException;
import it.unica.isw.ctm.validator.singleusetickets.SingleUseTicketValidatorCollector;

import java.util.Collection;
import java.util.HashSet;
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
	public void validate(Ticket ticket) throws Exception {
		Iterator<TicketValidator> i = validators.iterator();
		
		while (i.hasNext()) {
			try{
				i.next().validate(ticket);
				break;
			} catch (NoVendorValidatorException e) {
				throw new Exception("Vendor " + e.getTicket().getVendor() + " not found for " +
									TICKETS_KINDS.is(e.getTicket()).name());
			} catch (WrongValidatorException e) {
				continue;
			}
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		return true;
	}

	
	
}
