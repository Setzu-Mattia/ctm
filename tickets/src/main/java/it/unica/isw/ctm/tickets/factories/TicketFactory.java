package it.unica.isw.ctm.tickets.factories;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


public interface TicketFactory {
	
	final static VendorsFactories factories = VendorsFactories.getInstance();
	
	/**
	 * Get the given {@link kind} of ticket from the
	 * given {@link vendor}.
	 * @param vendor	The requested vendor.
	 * @param kind		The requeted ticket.
	 * @return			The requested ticket.
	 */
	Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS factory);
	
}
