package it.unica.isw.ctm.tickets.factories.test;

import junit.framework.Assert;
import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.factories.SingleUseTicketFactory;
import it.unica.isw.ctm.tickets.factories.TicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.tickets.vendors.factories.CTMSingleUseTicketsFactory;

public class DefaultSingleUseTicketFactoryTest {

	public void testGenerator() {
		
		TicketFactory factory = new AbstractSingleUseTicketFactory();
		
		SingleUseTicket tick90min0 = factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		SingleUseTicket tick120min0 = factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		
		Assert.assertFalse(tick90min0.equals(tick120min0));
	}
	
}
