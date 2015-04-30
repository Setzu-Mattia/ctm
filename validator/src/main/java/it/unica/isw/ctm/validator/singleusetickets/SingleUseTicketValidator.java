package it.unica.isw.ctm.validator.singleusetickets;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.validator.TicketValidator;
import it.unica.isw.ctm.validator.exceptions.NoVendorValidatorException;
import it.unica.isw.ctm.validator.exceptions.WrongValidatorKindException;


/**
 * Validate single tickets.
 */
public interface SingleUseTicketValidator extends TicketValidator {

	/**
	 * Validate single-use ticket.
	 * @param ticket		The ticket to validate.
	 * @throws Exception 	If something goes wrong.
	 */
	public void validate(SingleUseTicket ticket) throws NoVendorValidatorException,
															WrongValidatorKindException;
	
}
