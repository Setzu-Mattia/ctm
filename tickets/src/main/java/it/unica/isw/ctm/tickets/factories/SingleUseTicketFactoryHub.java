package it.unica.isw.ctm.tickets.factories;


import java.util.HashSet;
import java.util.Set;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.tickets.vendors.factories.ARSTSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.vendors.factories.CTMSingleUseTicketsFactory;


/**
 * Ticket generator for {@link SingleUseTicket}.
 */
public class SingleUseTicketFactoryHub {

	private final static Set<AbstractSingleUseTicketFactory> factories = new HashSet<AbstractSingleUseTicketFactory>();
	
	
	protected SingleUseTicket getSingleUseTicket(VENDORS vendor, SINGLE_USE_TICKETS kind) {
		switch(vendor) {
			case CTM:
				return ((SingleUseTicketFactory)VendorsFactories.getInstance().getTicketFactory(VENDORS.CTM)).getSingleUseTicket(kind);
			case ARST:
				return ((SingleUseTicketFactory)VendorsFactories.getInstance().getTicketFactory(VENDORS.ARST)).getSingleUseTicket(kind);
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
