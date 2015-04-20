package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


public class DefaultSingleUseTicketsFactory extends AbstractSingleUseTicketFactory {

	private static DefaultSingleUseTicketsFactory instance;
	private static SingleUseTicketFactoryHub factoriesHub;

	private DefaultSingleUseTicketsFactory() {
		factoriesHub = new SingleUseTicketFactoryHub()
							.buildCTMFactory()
							.buildARSTFactory();
	}
	
	public static DefaultSingleUseTicketsFactory getInstance() {
		if (instance == null)
			instance = new DefaultSingleUseTicketsFactory();
		return instance;
	}
	
	@Override
	public Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS kind) {
		return factoriesHub.getSingleUseTicket(vendor, kind);
	}
	
}
