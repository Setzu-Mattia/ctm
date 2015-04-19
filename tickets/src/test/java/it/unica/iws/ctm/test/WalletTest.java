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


public class WalletTest {

	private static DefaultSingleUseTicketFactory factory = new DefaultSingleUseTicketFactory();
	private static Random randomGenerator = new Random();
	
	private Set<Ticket> getRandomTickets(int n) {
		Set<Ticket> tickets = new HashSet<Ticket>();
		
		for (int i = 0; i < n; i++) {
			if(randomGenerator.nextBoolean())
				tickets.add(factory.get120MinutesTicket());
			else
				tickets.add(factory.get90MinutesTicket());
		}
		
		return tickets;
	}
	
	
	private void populateWallet(Wallet wallet, Set<Ticket> tickets) {
		for(Ticket current : tickets)
			wallet.addTicket(current);
	}
	
	public void testConstructor() {
		
		Wallet wallet = new Wallet();
		
		Assert.assertTrue(wallet.getTickets().size() == 0);
		
	}
	
	
	public void testAdd() {
		
		Wallet wallet = new Wallet();		
		Set<Ticket> tickets = getRandomTickets(10);		
		
		Assert.assertTrue(wallet.getTickets().size() == 0);
		
		populateWallet(wallet,tickets);
		
		Assert.assertTrue(wallet.getTickets().size() == 10);
		
		wallet.addTicket(factory.get120MinutesTicket());
		
		Assert.assertTrue(wallet.getTickets().size() == 11);
	}
	
	
	public void testRemove() {
		
		Wallet wallet = new Wallet();
		Set<Ticket> toRemove = new HashSet<Ticket>();
		
		populateWallet(wallet,getRandomTickets(50));
		Assert.assertTrue(wallet.getTickets().size() == 50);
		
		Collection<Ticket> ticketsAcquired = wallet.getTickets();
		
		Iterator<Ticket> iter = ticketsAcquired.iterator();
		
		for (int i = 0; i < 10; i++)
			toRemove.add(iter.next());
		
		Assert.assertTrue(wallet.getTickets().size() == 50);
		
		Object[] tickets = toRemove.toArray();
		
		for (int i = 0; i < 10; i++)
			wallet.removeTicket((Ticket	)tickets[i]);
		
		Assert.assertTrue(wallet.getTickets().size() == 40);
	}
	
}
