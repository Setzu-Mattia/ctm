package it.unica.isw.ctm.test;

import it.unica.isw.ctm.Wallet;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractTicketFactory;
import it.unica.isw.ctm.tickets.factories.TicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

import java.util.*;

import static junit.framework.Assert.assertTrue;


public class WalletTest {

	private static TicketFactory factory = AbstractTicketFactory.getInstance();
	private static Random randomGenerator = new Random();
	
	private Set<Ticket> getRandomTickets(int n) {
		Set<Ticket> tickets = new HashSet<Ticket>();
		
		for (int i = 0; i < n; i++) {
			if(randomGenerator.nextBoolean())
				tickets.add(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
			else
				tickets.add(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		}

		return tickets;
	}
	
	
	private void populateWallet(Wallet wallet, Set<Ticket> tickets) {
		for(Ticket current : tickets)
			wallet.addTicket(current);
	}
	
	public void testConstructor() {
		Wallet.getInstance().clear();
		assertTrue(Wallet.getInstance().getTickets().size() == 0);
	}
	
	
	public void testAdd() {
		Wallet.getInstance().clear();
		Set<Ticket> tickets = getRandomTickets(10);		

		assertTrue(Wallet.getInstance().getTickets().size() == 0);
		
		populateWallet(Wallet.getInstance(),tickets);
		
		assertTrue(Wallet.getInstance().getTickets().size() == 10);
		
		Wallet.getInstance().addTicket(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
		
		assertTrue(Wallet.getInstance().getTickets().size() == 11);
	}
	
	
	public void testRemove() {
		Wallet.getInstance().clear();
		Set<Ticket> toRemove = new HashSet<Ticket>();
		
		populateWallet(Wallet.getInstance(),getRandomTickets(50));
		
		assertTrue(Wallet.getInstance().getTickets().size() == 50);
		
		Collection<Ticket> ticketsAcquired = Wallet.getInstance().getTickets();
		
		Iterator<Ticket> iter = ticketsAcquired.iterator();
		
		for (int i = 0; i < 10; i++)
			toRemove.add(iter.next());
		
		for (Ticket current : toRemove)
			Wallet.getInstance().removeTicket(current);

		assertTrue(Wallet.getInstance().getTickets().size() == 40);
		
		Object[] tickets = toRemove.toArray();
		
		for (int i = 0; i < 10; i++)
			Wallet.getInstance().removeTicket((Ticket)tickets[i]);
		
		assertTrue(Wallet.getInstance().getTickets().size() == 40);
	}
	
}
