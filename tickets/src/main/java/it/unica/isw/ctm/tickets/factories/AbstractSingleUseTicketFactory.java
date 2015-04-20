package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.exceptions.FactoryTypeException;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Abstract interface for ticket generation.
 */
public class AbstractSingleUseTicketFactory implements TicketFactory {
	
	private static SingleUseTicketFactoryHub factoriesHub = new SingleUseTicketFactoryHub()
																	.buildCTMFactory()
																	.buildARSTFactory();

	
	/**
	 * Get a single use ticket.
	 * @param vendor	The vendor requested.
	 * @param ticket	The ticket requested.
	 * @return			The requested ticket.
	 */
	public Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS ticket) {
		return factoriesHub.getSingleUseTicket(vendor, ticket);
	}


	public Ticket getTicket(VENDORS vendor, TICKETS_KINDS kind) {
		if (kind == TICKETS_KINDS.SINGLE_USE_TICKET)
			return ((Ticket)(getTicket(vendor,kind)));
		throw new FactoryTypeException(vendor, kind);
	}
	
}
