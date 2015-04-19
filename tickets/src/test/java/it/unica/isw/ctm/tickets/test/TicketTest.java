package it.unica.isw.ctm.tickets.test;

import junit.framework.Assert;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;


public class TicketTest {

	public boolean testEquals() throws Exception {
		long id0 = 3412341234132L;
		long id1 = 43434132412341L;
		
		Ticket90minutes tick90min0 = new Ticket90minutes(id0);
		Ticket90minutes tick120min0 = new Ticket90minutes(id1);
		
		Assert.assertTrue(tick90min0.equals(tick90min0));
		Assert.assertTrue(tick120min0.equals(tick120min0));
		
		Assert.assertFalse(tick90min0.equals(tick120min0));
		Assert.assertFalse(tick120min0.equals(tick90min0));
		
		Ticket120minutes tick120min1 = new Ticket120minutes(id0);
		
		Assert.assertTrue(tick120min1.equals(tick90min0));
		
		return true;
	}
	
}
