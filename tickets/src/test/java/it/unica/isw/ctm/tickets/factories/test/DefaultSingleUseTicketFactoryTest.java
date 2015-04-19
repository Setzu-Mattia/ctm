package it.unica.isw.ctm.tickets.factories.test;

import junit.framework.Assert;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;

public class DefaultSingleUseTicketFactoryTest {

	public void testGenerator() {
		
		DefaultSingleUseTicketFactory factory = new DefaultSingleUseTicketFactory();
		
		Ticket90minutes tick90min0 = factory.get90MinutesTicket();
		Ticket120minutes tick120min0 = factory.get120MinutesTicket();
		
		Assert.assertFalse(tick90min0.equals(tick120min0));
	}
	
}
