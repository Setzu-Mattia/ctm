package it.unica.isw.ctm.tickets.iterators.test;

import java.util.ArrayList;
import java.util.List;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.iterators.singleusetickets.SingleUse90minutesTicketIterator;
import it.unica.isw.ctm.tickets.iterators.singleusetickets.SingleUseTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

import org.junit.Assert;
import org.junit.Test;


public class SingleUseTicketIteratorsTest {

	@Test
	public void testSingleUseIterate() {
		DefaultSingleUseTicketsFactory factory = DefaultSingleUseTicketsFactory.getInstance();
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		SingleUseTicketIterator emptyIterator = new SingleUseTicketIterator(tickets);
		int tickets120 = 0;
		int tickets90 = 0;


		while (emptyIterator.hasNext()) {
			SingleUseTicket current = emptyIterator.next();
			if (SINGLE_USE_TICKETS.is(current) == SINGLE_USE_TICKETS.TICKET_120MINUTES)
				tickets120++;
			else
				tickets90++;
		}
		

		Assert.assertTrue(tickets120 == 0);
		Assert.assertTrue(tickets90 == 0);
		
		
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
		
		
		
		SingleUseTicketIterator iterator = new SingleUseTicketIterator(tickets);
		
		while (iterator.hasNext()) {
			SingleUseTicket current = iterator.next();
			if (SINGLE_USE_TICKETS.is(current) == SINGLE_USE_TICKETS.TICKET_120MINUTES)
				tickets120++;
			else
				tickets90++;
		}
		
		Assert.assertTrue(tickets120 == 5);
		Assert.assertTrue(tickets90 == 5);
		
	}

	
	@Test
	public void test90minutesIterate() {
		DefaultSingleUseTicketsFactory factory = DefaultSingleUseTicketsFactory.getInstance();
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		SingleUse90minutesTicketIterator emptyIterator = new SingleUse90minutesTicketIterator(tickets);
		int tickets120 = 0;
		int tickets90 = 0;


		while (emptyIterator.hasNext()) {
			emptyIterator.next();
			tickets90++;
		}
		
		Assert.assertTrue(tickets90 == 0);
		
		
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		tickets.add((SingleUseTicket) factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
		
		
		
		SingleUseTicketIterator iterator90 = new SingleUseTicketIterator(tickets);
		SingleUseTicketIterator iterator120 = new SingleUseTicketIterator(tickets);
		
		while (iterator90.hasNext()) {
			iterator90.next();
			tickets90++;
		}
		
		while (iterator120.hasNext()) {
			iterator120.next();
			tickets120++;
		}
		
		Assert.assertTrue(tickets120 == 5);
		Assert.assertTrue(tickets90 == 5);
		
	}
	
}
