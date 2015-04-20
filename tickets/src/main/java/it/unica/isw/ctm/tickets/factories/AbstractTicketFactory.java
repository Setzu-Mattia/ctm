package it.unica.isw.ctm.tickets.factories;

import java.util.Collection;
import java.util.HashSet;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

public class AbstractTicketFactory implements TicketFactory {

	private static AbstractTicketFactory instance;
	private static Collection<TicketFactory> kindsFactories;
	
	
	private AbstractTicketFactory() {
		instance = new AbstractTicketFactory();
		AbstractTicketFactory.kindsFactories = new HashSet<TicketFactory>();
		AbstractTicketFactory.kindsFactories.add(DefaultSingleUseTicketsFactory.getInstance());
	}
	
	private Collection<TicketFactory> getKindsFactories() {
		return kindsFactories;
	}
	
	private Collection<TicketFactory> setKindsFactories(Collection<TicketFactory> kindsFactories) {
		this.kindsFactories = kindsFactories;
	}
	
	@Override
	public Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
