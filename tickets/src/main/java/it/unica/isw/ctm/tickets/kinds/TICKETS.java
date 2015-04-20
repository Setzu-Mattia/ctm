package it.unica.isw.ctm.tickets.kinds;

import it.unica.isw.ctm.tickets.Ticket;

public enum TICKETS {
	
	CTM_TICKET,
	ARST_TICKET,
	UNKNOWN;
	
	/**
	 * Identify the ticket kind.
	 * @param ticket	The ticket to identify.
	 * @return			The ticket's kind.
	 * @throws Exception 
	 */
	public TICKETS is(Ticket ticket) {
		switch(ticket.getVendor()) {
			case CTM:
				return CTM_TICKET;
			case ARST:
				return ARST_TICKET;
		}
		return UNKNOWN;
	}
	
}
