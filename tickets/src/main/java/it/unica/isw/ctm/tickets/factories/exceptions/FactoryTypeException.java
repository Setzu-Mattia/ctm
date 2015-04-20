package it.unica.isw.ctm.tickets.factories.exceptions;

import it.unica.isw.ctm.tickets.kinds.TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Exception thrown when querying the wrong
 * factory for a ticket.
 */
public class FactoryTypeException extends RuntimeException {

	private VENDORS vendor;
	private TICKETS ticketType;
	
	
	/**
	 * Default constructor.
	 * @param vendor		The vendor requested.
	 * @param ticketType	The ticket requested.
	 */
	public FactoryTypeException(VENDORS vendor, TICKETS ticketType) {
		this.vendor = vendor;
		this.ticketType = ticketType;
	}


	public VENDORS getVendor() {
		return vendor;
	}


	public TICKETS getTicketType() {
		return ticketType;
	}	
	
}
