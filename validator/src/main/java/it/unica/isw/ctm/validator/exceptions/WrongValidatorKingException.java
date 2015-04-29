package it.unica.isw.ctm.validator.exceptions;

import it.unica.isw.ctm.tickets.Ticket;


/**
 * Exception thrown when trying to validate a {@link TICKETS_KINDS}
 * of the wrong type in a validator.
 */
public class WrongValidatorKingException extends RuntimeException {

	/** The ticket causing the exception */
	private Ticket ticket;
	
	
	public WrongValidatorKingException (Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}
	
}
