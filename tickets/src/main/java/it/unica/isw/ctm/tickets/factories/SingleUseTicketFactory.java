package it.unica.isw.ctm.tickets.factories;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;

public interface SingleUseTicketFactory extends TicketFactory {
	
	SingleUseTicket getSingleUseTicket(SINGLE_USE_TICKETS ticket);
	
}
