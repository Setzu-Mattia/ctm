package it.unica.isw.ctm.tickets.factories;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

public class DefaultSingleUseTicketsFactory extends AbstractSingleUseTicketFactory {

	private static DefaultSingleUseTicketsFactory instance;
	private static SingleUseTicketFactoryHub factoriesHub = new SingleUseTicketFactoryHub()
																	.buildCTMFactory()
																	.buildARSTFactory();

	@Override
	public SingleUseTicket getTicket(VENDORS vendor, SINGLE_USE_TICKETS kind) {
		return factoriesHub.getSingleUseTicket(vendor, kind);
	}
	
}
