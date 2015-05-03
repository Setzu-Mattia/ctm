package it.unica.isw.ctm.tickets.iterators.singleusetickets;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.iterators.AbstractTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;


/**
 * A iterator over {@link SingleUseTicket}s.
 */
public class SingleUseTicketIterator<T extends SingleUseTicket> extends AbstractTicketIterator<Ticket>
										implements Iterator<SingleUseTicket> {


	protected SINGLE_USE_TICKETS singleKind;
	
	public SingleUseTicketIterator(List<Ticket> collection) {
		super(collection, TICKETS_KINDS.SINGLE_USE_TICKET);
	}
	
	
	public SingleUseTicketIterator(List<Ticket> collection, SINGLE_USE_TICKETS singleKind) {
		super(collection, TICKETS_KINDS.SINGLE_USE_TICKET);
		this.singleKind = singleKind;
	}
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		System.out.println("collection has size: " + collection.size());
		return hasNextTicket(position, collection.size());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SingleUseTicket next() throws NoSuchElementException {
		return (SingleUseTicket) nextTicket();
	}
	
}