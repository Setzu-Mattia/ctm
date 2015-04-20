package it.unica.isw.ctm.tickets.kinds;

import it.unica.isw.ctm.tickets.Ticket;

public enum TICKETS_KINDS {
	
	SINGLE_USE_TICKET;
	
	/**
	 * Identify the ticket kind.
	 * @param ticket	The ticket to identify.
	 * @return			The ticket's kind.
	 * @throws Exception 
	 */
	public static TICKETS_KINDS is(Ticket ticket) {
		return SINGLE_USE_TICKET;
	}

}
