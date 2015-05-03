package it.unica.isw.ctm;


import it.unica.isw.ctm.tickets.Ticket;

import java.util.*;

public class Wallet extends Observable {

	private static Wallet wallet;
	private Collection<Ticket> tickets;
	private Set<Observer> observers;

	
	private Wallet() {
		tickets = new Vector<Ticket>();
		observers = new HashSet<Observer>();
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
		setChanged();
	}
	
	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		setChanged();
	}
	
	public void clear() {
		Wallet.getInstance().tickets.clear();
		setChanged();
	}

}