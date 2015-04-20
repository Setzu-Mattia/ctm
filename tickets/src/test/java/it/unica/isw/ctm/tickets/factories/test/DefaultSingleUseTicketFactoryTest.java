package it.unica.isw.ctm.tickets.factories.test;

import junit.framework.Assert;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractTicketFactory;
import it.unica.isw.ctm.tickets.factories.TicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


public class DefaultSingleUseTicketFactoryTest {

	public void testGenerator() {
		
		TicketFactory factory = AbstractTicketFactory.getInstance();
		
		Ticket tick90min0 = factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		Ticket tick120min0 = factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		
		Assert.assertFalse(tick90min0.equals(tick120min0));
	}
	
}
