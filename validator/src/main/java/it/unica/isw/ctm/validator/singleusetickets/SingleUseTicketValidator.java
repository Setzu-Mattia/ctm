package it.unica.isw.ctm.validator.singleusetickets;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.validator.TicketValidator;


/**
 * Validate single tickets.
 */
public interface SingleUseTicketValidator extends TicketValidator {

	/**
	 * Validate single-use ticket.
	 * @param ticket		The ticket to validate.
	 * @throws Exception 	If something goes wrong.
	 */
	public void validate(SingleUseTicket ticket) throws Exception;
	
}
