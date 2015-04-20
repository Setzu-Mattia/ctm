package it.unica.iws.ctm.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

import junit.framework.Assert;
import it.unica.isw.ctm.Wallet;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


public class WalletTest {

	private static DefaultSingleUseTicketFactory factory = new DefaultSingleUseTicketFactory();
	private static Random randomGenerator = new Random();
	
	private Set<Ticket> getRandomTickets(int n) {
		Set<Ticket> tickets = new HashSet<Ticket>();
		
		for (int i = 0; i < n; i++) {
			if(randomGenerator.nextBoolean())
				tickets.add(factory.get120MinutesTicket(VENDORS.CTM));
			else
				tickets.add(factory.get90MinutesTicket(VENDORS.ARST));
		}
		
		return tickets;
	}
	
	
	private void populateWallet(Wallet wallet, Set<Ticket> tickets) {
		for(Ticket current : tickets)
			wallet.addTicket(current);
	}
	
	public void testConstructor() {		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 0);
	}
	
	
	public void testAdd() {
		
		Set<Ticket> tickets = getRandomTickets(10);		
		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 0);
		
		populateWallet(Wallet.getInstance(),tickets);
		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 10);
		
		Wallet.getInstance().addTicket(factory.get120MinutesTicket(VENDORS.CTM));
		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 11);
	}
	
	
	public void testRemove() {
		
		Set<Ticket> toRemove = new HashSet<Ticket>();
		
		populateWallet(Wallet.getInstance(),getRandomTickets(50));
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 50);
		
		Collection<Ticket> ticketsAcquired = Wallet.getInstance().getTickets();
		
		Iterator<Ticket> iter = ticketsAcquired.iterator();
		
		for (int i = 0; i < 10; i++)
			toRemove.add(iter.next());
		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 50);
		
		Object[] tickets = toRemove.toArray();
		
		for (int i = 0; i < 10; i++)
			Wallet.getInstance().removeTicket((Ticket	)tickets[i]);
		
		Assert.assertTrue(Wallet.getInstance().getTickets().size() == 40);
	}
	
}
