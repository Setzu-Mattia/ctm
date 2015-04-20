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
		AbstractTicketFactory.kindsFactories = new HashSet<TicketFactory>();
		AbstractTicketFactory.kindsFactories.add(DefaultSingleUseTicketsFactory.getInstance());
	}
	
	
	public static AbstractTicketFactory getInstance() {
		if (instance == null)
			instance = new AbstractTicketFactory();
		return instance;
	}
	
	
	@Override
	public Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS ticket) {
		for (TicketFactory current : kindsFactories)
			if (current.equals(DefaultSingleUseTicketsFactory.getInstance()))
				return current.getTicket(vendor, ticket);
		return null;
	}

}
