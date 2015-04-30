/**
 * Provide validation for tickets.
 */
package it.unica.isw.ctm.validator.singleusetickets;


import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.validator.AbstractTicketValidator;
import it.unica.isw.ctm.validator.TicketValidator;
import it.unica.isw.ctm.validator.exceptions.NoSuitableValidatorException;
import it.unica.isw.ctm.validator.exceptions.NoVendorValidatorException;
import it.unica.isw.ctm.validator.exceptions.WrongValidatorKindException;


/**
 * Tickets validator.
 */
public class SingleUseTicketValidatorCollector extends AbstractTicketValidator implements SingleUseTicketValidator {
	
	private static SingleUseTicketValidatorCollector instance;
	private TicketValidator head;
	
	
	private SingleUseTicketValidatorCollector() {
		head = (TicketValidator) ARSTSingleUseTicketValidator.getInstance();
	}
	
	
	public static SingleUseTicketValidatorCollector getInstance() {
		if (instance == null)
			instance = new SingleUseTicketValidatorCollector();
		return instance;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Ticket ticket) throws NoSuitableValidatorException {
		if (canValidate(ticket)){
			try {
				validate((SingleUseTicket)ticket);
			} catch(NoSuitableValidatorException e) {
				throw new NoVendorValidatorException(ticket);
			}
		}
		throw new WrongValidatorKindException(ticket);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		return TICKETS_KINDS.is(ticket) == TICKETS_KINDS.SINGLE_USE_TICKET;
	}


	@Override
	public void validate(SingleUseTicket ticket) throws NoSuitableValidatorException {
		head.validate(ticket);		
	}
	
}
