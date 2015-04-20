package it.unica.isw.ctm;


import it.unica.isw.ctm.tickets.Ticket;

import java.util.Collection;
import java.util.Vector;

public class Wallet {

	private static Wallet wallet;
	private Collection<Ticket> tickets;

	
	private Wallet() {
		tickets = new Vector<Ticket>();
	}

	
	public static Wallet getInstance() {
		if(wallet == null)
			wallet = new Wallet();
		return wallet;
	}
	

	public Collection<Ticket> getTickets() {
		return tickets;
	}
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
	}
	
	public void clear() {
		Wallet.getInstance().tickets.clear();
	}
	
}
