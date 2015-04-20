/**
 * Provide validation for tickets.
 */
package it.unica.isw.ctm.validator;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

/**
 * Tickets validator.
 */
public abstract class AbstractValidator {

	private Map<SINGLE_USE_TICKETS,Time> times;
	private final long HALF_HOUR_MS = 1800000;
	
	public AbstractValidator() {
		times = new HashMap<SINGLE_USE_TICKETS,Time>();
		
		times.put(SINGLE_USE_TICKETS.TICKET_90MINUTES, new Time(HALF_HOUR_MS*3L));
		times.put(SINGLE_USE_TICKETS.TICKET_120MINUTES, new Time(HALF_HOUR_MS*4L));
	}
	
	
	/**
	 * Validate the given ticket.
	 * @param ticket
	 */
	public abstract void validate(Ticket ticket);
	
}
