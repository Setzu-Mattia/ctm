package it.unica.isw.ctm.validator.exceptions;

import it.unica.isw.ctm.tickets.Ticket;


/**
 * Exception thrown when no vendor for the given ticket is found.
 */
public class NoVendorValidatorException extends RuntimeException {

	/** The ticket causing the exception */
	private Ticket ticket;
	
	
	public NoVendorValidatorException (Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}
	
}
