package it.unica.isw.ctm.validator.exceptions;

import it.unica.isw.ctm.tickets.Ticket;


/**
 * Exception thrown on no validators found.
 */
public class NoSuitableValidatorFoundException extends RuntimeException {

	private Ticket ticket;
	
	public NoSuitableValidatorFoundException(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}
	
}
