package it.unica.isw.ctm.validator;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.validator.exceptions.NoSuitableValidatorException;
import it.unica.isw.ctm.validator.exceptions.WrongValidatorKindException;
import it.unica.isw.ctm.validator.singleusetickets.SingleUseTicketValidatorCollector;

import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;


/**
 * Collector for {@link TicketValidator}.
 */
public class TicketValidatorCollector implements TicketValidator {

	private static TicketValidatorCollector instance;
	private Collection<TicketValidator> validators;
	
	
	/**
	 * Default constructor.
	 */
	private TicketValidatorCollector() {
		validators = new Vector<TicketValidator>();
		
		validators.add(SingleUseTicketValidatorCollector.getInstance());		
	}
	
	
	public static TicketValidatorCollector getInstance() {
		if (instance == null)
			instance = new TicketValidatorCollector();
		return instance;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Ticket ticket) throws NoSuitableValidatorException {
		
		if (!canValidate(ticket))
			throw new NoSuitableValidatorException(ticket);
		
		Iterator<TicketValidator> i = validators.iterator();
		
		while (i.hasNext()) {
			try{
				i.next().validate(ticket);
				return;
			} // Wrong validator, switch to next 
			catch (WrongValidatorKindException e) {
				continue;
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		switch (TICKETS_KINDS.is(ticket)) {
		case SINGLE_USE_TICKET:
			return true;
		default:
			return false;		
		}
	}

	
	
}
