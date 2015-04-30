package it.unica.isw.ctm.validator.exceptions;

import it.unica.isw.ctm.tickets.Ticket;


/**
 * Exception thrown when no vendor for the given ticket is found.
 */
public class NoVendorValidatorException extends NoSuitableValidatorException {
	
	public NoVendorValidatorException (Ticket ticket) {
		super(ticket);
	}
	
}
