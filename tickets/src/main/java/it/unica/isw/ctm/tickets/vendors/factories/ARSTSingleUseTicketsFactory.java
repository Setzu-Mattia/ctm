package it.unica.isw.ctm.tickets.vendors.factories;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.factories.SingleUseTicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


public class ARSTSingleUseTicketsFactory extends AbstractSingleUseTicketFactory
													implements SingleUseTicketFactory {

	private static ARSTSingleUseTicketsFactory instance;
	
	private static Set<SingleUseTicket> generatedTickets;
	private static Random randomGenerator;
	
	
	private ARSTSingleUseTicketsFactory() {
		generatedTickets = new HashSet<SingleUseTicket>();
		randomGenerator = new Random();
	}
	
	
	public static ARSTSingleUseTicketsFactory getInstance() {
		if (instance == null)
			instance = new ARSTSingleUseTicketsFactory();
		return instance;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SingleUseTicket getSingleUseTicket(SINGLE_USE_TICKETS kind) {
		switch(kind) {
			case TICKET_120MINUTES:
				SingleUseTicket new120minutesTicket = new Ticket120minutes(VENDORS.ARST,generateId());
				generatedTickets.add(new120minutesTicket);
				return new120minutesTicket;
			case TICKET_90MINUTES:
				SingleUseTicket new90minutesTicket = new Ticket90minutes(VENDORS.ARST,generateId());
				generatedTickets.add(new90minutesTicket);
				return new90minutesTicket;
			default:
				return null;
		}
	}
	
	
	public Ticket getTicket(VENDORS vendor, SINGLE_USE_TICKETS kind) {
		return (Ticket)getSingleUseTicket(kind);		
	}

	
	protected long generateId() {
		return randomGenerator.nextLong();
	}

}
