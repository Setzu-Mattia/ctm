package it.unica.isw.ctm.tickets.kinds;

import it.unica.isw.ctm.tickets.singleusetickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;


/**
 * Enumerate tickets available.
 */
public enum SINGLE_USE_TICKETS {

	TICKET_90MINUTES,
	TICKET_120MINUTES;

	
	/**
	 * Identify a SingleUseTicket type.
	 * @param ticket	The ticket to check.
	 * @return			The ticket type.
	 */
	public static SINGLE_USE_TICKETS is(SingleUseTicket ticket) {
		if (ticket instanceof Ticket90minutes)
			return TICKET_90MINUTES;
		
		return TICKET_120MINUTES;
	}
	
}
