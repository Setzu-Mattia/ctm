/**
 * Provide validation for tickets.
 */
package it.unica.isw.ctm.validator.singleusetickets;

import it.unica.isw.ctm.validator.TicketValidator;
import it.unica.isw.ctm.validator.TicketValidatorCollector;


/**
 * Tickets validator.
 */
public class SingleUseTicketValidatorCollector extends AbstractTicketValidator {
	
	private static SingleUseTicketValidatorCollector instance;
	private TicketValidator head;
	
	private SingleUseTicketValidatorCollector() {
		head = () ARSTSingleUseTicketValidator.getInstance();
	}
	
	
	public static SingleUseTicketValidatorCollector getInstance() {
		if (instance == null)
			instance = new SingleUseTicketValidatorCollector();
		return instance;
	}


	@Override
	public TicketValidator getNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
