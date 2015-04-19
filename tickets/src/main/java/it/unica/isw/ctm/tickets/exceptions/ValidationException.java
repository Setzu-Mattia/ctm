package it.unica.isw.ctm.tickets.exceptions;


/**
 * Exception thrown when a ticket can't be validated.
 */
public class ValidationException extends RuntimeException {

	private final long id;
	
	/**
	 * @param id	The ticket's.
	 */
	public ValidationException(long id) {
		this.id = id;
	}
	
	
	public long getId() {
		return id;
	}
	
}
