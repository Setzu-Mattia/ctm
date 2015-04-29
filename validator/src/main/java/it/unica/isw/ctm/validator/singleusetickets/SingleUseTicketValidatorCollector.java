/**
 * Provide validation for tickets.
 */
package it.unica.isw.ctm.validator.singleusetickets;


import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.validator.AbstractTicketValidator;
import it.unica.isw.ctm.validator.TicketValidator;
import it.unica.isw.ctm.validator.exceptions.NoVendorValidatorException;
import it.unica.isw.ctm.validator.exceptions.WrongValidatorKingException;


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
	public void validate(Ticket ticket) throws Exception {
		if (canValidate(ticket)){
			try {
				validate((SingleUseTicket)ticket);
			} catch(NullPointerException e) {
				throw new NoVendorValidatorException(ticket);
			}
		}
		throw new WrongValidatorKingException(ticket);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		return TICKETS_KINDS.is(ticket) == TICKETS_KINDS.SINGLE_USE_TICKET;
	}


	@Override
	public void validate(SingleUseTicket ticket) throws Exception {
		head.validate(ticket);		
	}
	
}
