package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Abstract interface for ticket generation.
 */
public abstract class AbstractSingleUseTicketFactory implements TicketFactory {	
	
	private static SingleUseTicketFactoryHub factoriesHub = new SingleUseTicketFactoryHub()
																	.buildCTMFactory()
																	.buildARSTFactory();
	
	/**
	 * Generate a unique ID.
	 * @return		A unique id.
	 */
	protected abstract long generateId();
	
	
	/**
	 * Get a single use ticket.
	 * @param vendor	The vendor requested.
	 * @param ticket	The ticket requested.
	 * @return			The requested ticket.
	 */
	public SingleUseTicket getTicket(VENDORS vendor, SINGLE_USE_TICKETS ticket) {
		return factoriesHub.getSingleUseTicket(vendor, ticket);
	}
	
	
	/**
	 * Get the requested ticket.
	 * @param vendor	The vendor requested.
	 * @param ticket	The ticket requested.
	 * @return			The requested ticket.	 
	 */
	protected abstract SingleUseTicket getSingleUseTicket(SINGLE_USE_TICKETS kind);
	
}
