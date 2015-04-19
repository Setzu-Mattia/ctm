package it.unica.isw.ctm.tickets.exceptions.info;


/**
 * Exception stating that a ticket has no validation
 * date.
 */
public class NoValidationDateFoundException extends NoDateFoundException {	
	
	public NoValidationDateFoundException(long id) {
		super(id);
	}
	
}
