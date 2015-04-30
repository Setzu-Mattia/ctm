package it.unica.isw.ctm.validator.exceptions;

import it.unica.isw.ctm.tickets.Ticket;


/**
 * Exception thrown when trying to validate a {@link TICKETS_KINDS}
 * of the wrong type in a validator.
 */
public class WrongValidatorKindException extends NoVendorValidatorException {

	public WrongValidatorKindException (Ticket ticket) {
		super(ticket);
	}
	
}
