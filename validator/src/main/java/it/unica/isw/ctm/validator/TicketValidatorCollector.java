package it.unica.isw.ctm.validator;


/**
 * Collector for {@link TicketValidator}.
 */
public abstract class TicketValidatorCollector {

	protected TicketValidator next;
	
	
	/**
	 * Get next validator.
	 * @return 						The next validator, if present.
	 * @throws NullPointerException 	If there's no next validator.
	 */
	public abstract TicketValidator getNext();

}
