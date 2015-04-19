package it.unica.isw.ctm;


import it.unica.isw.ctm.tickets.Ticket;

import java.util.Collection;
import java.util.Vector;

public class Wallet {

	private Collection<Ticket> tickets;

	
	public Wallet() {
		tickets = new Vector<Ticket>();
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
	
}
