package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Ticket generator for {@link SingleUseTicket}.
 */
public class DefaultSingleUseTicketFactory extends AbstractSingleUseTicketFactory {

	public Ticket90minutes get90MinutesTicket(VENDORS vendor) {
		return new Ticket90minutes(vendor, generateId());
	}

	
	public Ticket120minutes get120MinutesTicket(VENDORS vendor) {
		return new Ticket120minutes(vendor, generateId());
	}
	
}
