package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;


/**
 * Ticket generator for {@link SingleUseTicket}.
 */
public class DefaultSingleUseTicketFactory extends AbstractSingleUseTicketFactory {

	public Ticket90minutes get90MinutesTicket() {
		return new Ticket90minutes(generateId());
	}

	
	public Ticket120minutes get120MinutesTicket() {
		return new Ticket120minutes(generateId());
	}
	
}
