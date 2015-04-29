package it.unica.isw.ctm.validator.singleusetickets;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.validator.TicketValidator;


/**
 * Validate single tickets.
 */
public interface SingleUseTicketValidator extends TicketValidator {

	/**
	 * Validate single-use ticket.
	 * @param ticket	The ticket to validate.
	 */
	public void validate(SingleUseTicket ticket);
	
}
