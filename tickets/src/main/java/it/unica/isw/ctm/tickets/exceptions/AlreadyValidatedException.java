package it.unica.isw.ctm.tickets.exceptions;


/**
 * Exception thronw when a ticket already
 * reached its maximum number of validations.
 *
 */
public class AlreadyValidatedException extends ValidationException {

	public AlreadyValidatedException(long id) {
		super(id);
	}
	
}