package it.unica.isw.ctm.validator.singleusetickets;

import it.unica.isw.ctm.validator.AbstractTicketValidator;
import it.unica.isw.ctm.validator.TicketValidator;


/**
 * An abstract single-use tickets validator.
 */
public abstract class AbstractSingleUseTicketValidator extends AbstractTicketValidator {

	/**
	 * Get the next validator in line, if present
	 * @return								The next validator, if present.
	 * @throws		NullPointerException	If next is null.
	 */
	public abstract TicketValidator getNext() throws NullPointerException;
	
}
