package it.unica.isw.ctm.validator;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.validator.exceptions.NoSuitableValidatorException;

/**
 * A ticket validator.
 */
public interface TicketValidator {

	/**
	 * Validate the given ticket.
	 * @param ticket
	 * @throws Exception 		If validator could not validate.
	 */
	public abstract void validate(Ticket ticket) throws NoSuitableValidatorException;
	
	
	
	/**
	 * Check if the validator can obliterate {@code ticket}.
	 * Used by {@code validate} to check if validate or not
	 * the ticket.
	 * @param ticket	The ticket to check.
	 * @return			True if it can, false otherwise.
	 */
	public abstract boolean canValidate(Ticket ticket);
	
}
