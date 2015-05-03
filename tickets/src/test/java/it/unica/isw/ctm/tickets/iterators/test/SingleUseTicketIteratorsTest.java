package it.unica.isw.ctm.tickets.iterators.test;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.iterators.KindTicketIterator;
import it.unica.isw.ctm.tickets.iterators.singleusetickets.SingleUse120minutesTicketIterator;
import it.unica.isw.ctm.tickets.iterators.singleusetickets.SingleUse90minutesTicketIterator;
import it.unica.isw.ctm.tickets.iterators.singleusetickets.SingleUseTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class SingleUseTicketIteratorsTest {

	@Test
	public void testSingleUseIterate() {
		DefaultSingleUseTicketsFactory factory = DefaultSingleUseTicketsFactory.getInstance();
		List<Ticket> tickets = new ArrayList<Ticket>();

		KindTicketIterator  emptyIterator = new KindTicketIterator<Ticket>(tickets, TICKETS_KINDS.SINGLE_USE_TICKET);
		int ticketsN = 0;


		while (emptyIterator.hasNext()) {
			emptyIterator.next();
			ticketsN++;
		}
		

		assertTrue(ticketsN == 0);
		
		
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));

		emptyIterator = new KindTicketIterator<Ticket>(tickets, TICKETS_KINDS.SINGLE_USE_TICKET);
		while (emptyIterator.hasNext()) {
			emptyIterator.next();
			ticketsN++;
		}

		assertTrue(ticketsN == 10);
		
	}

	
	@Test
	public void test90minutesIterate() {
		DefaultSingleUseTicketsFactory factory = DefaultSingleUseTicketsFactory.getInstance();
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		SingleUse90minutesTicketIterator emptyIterator = new SingleUse90minutesTicketIterator(tickets);
		int tickets90 = 0;


		while (emptyIterator.hasNext()) {
			emptyIterator.next();
			tickets90++;
		}
		
		assertTrue(tickets90 == 0);
		
		
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		
		
		
		SingleUseTicketIterator iterator90 = new SingleUse90minutesTicketIterator(tickets);
		SingleUseTicketIterator iterator120 = new SingleUse120minutesTicketIterator(tickets);
		int tickets120 = 0;


		while (iterator90.hasNext()) {
			iterator90.next();
			tickets90++;
		}
		
		while (iterator120.hasNext()) {
			iterator120.next();
			tickets120++;
		}

		assertTrue(tickets120 == 5);
		assertTrue(tickets90 == 5);
		
	}
	
}
