package it.unica.isw.ctm.tickets.exceptions.info;

/**
 * Exception stating that a ticket has no info on its
 * validating or expiring date.
 */
public abstract class NoDateFoundException extends RuntimeException {
	
	/** The ticket's id.  */
	private long id;
	
	public NoDateFoundException(long id) {
		this.id = id;
	}

	
	public long getId() {
		return id;
	}
	
}
