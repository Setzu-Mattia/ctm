package it.unica.isw.ctm.tickets.factories;


import java.util.HashSet;
import java.util.Set;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.tickets.vendors.factories.ARSTSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.vendors.factories.CTMSingleUseTicketsFactory;


/**
 * Ticket generator for {@link SingleUseTicket}.
 */
public class SingleUseTicketFactoryHub {

	private final static Set<AbstractSingleUseTicketFactory> factories = new HashSet<AbstractSingleUseTicketFactory>();
	
	
	protected Ticket getSingleUseTicket(VENDORS vendor, SINGLE_USE_TICKETS kind) {
		switch(vendor) {
			case CTM:
				return VendorsFactories.getInstance().getTicketFactory(VENDORS.CTM, TICKETS_KINDS.SINGLE_USE_TICKET).getTicket(VENDORS.CTM, kind);
			case ARST:
				return VendorsFactories.getInstance().getTicketFactory(VENDORS.ARST, TICKETS_KINDS.SINGLE_USE_TICKET).getTicket(VENDORS.CTM, kind);
			default:
				return null;
		}
	}

	
	public SingleUseTicketFactoryHub buildCTMFactory() {
		factories.add(CTMSingleUseTicketsFactory.getInstance());
		return this;
	}

	public SingleUseTicketFactoryHub buildARSTFactory() {
		factories.add(ARSTSingleUseTicketsFactory.getInstance());
		return this;
	}

	
}
