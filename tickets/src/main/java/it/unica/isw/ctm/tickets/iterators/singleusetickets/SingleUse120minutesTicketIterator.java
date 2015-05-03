package it.unica.isw.ctm.tickets.iterators.singleusetickets;

import java.util.Iterator;
import java.util.List;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.iterators.AbstractTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;

/**
 * A iterator over {@link Ticket120minutes}s.
 */
public class SingleUse120minutesTicketIterator extends AbstractTicketIterator<SingleUseTicket> 
												implements Iterator<Ticket120minutes> {
	
	public SingleUse120minutesTicketIterator(List<SingleUseTicket> collection) {
		super(collection, TICKETS_KINDS.SINGLE_USE_TICKET);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		SingleUseTicket ticket = (SingleUseTicket) nextTicket();
		if (SINGLE_USE_TICKETS.is(ticket) == SINGLE_USE_TICKETS.TICKET_120MINUTES)
			return true;
		return hasNext();
	}
	
	
	public Ticket120minutes next() {
		SingleUseTicket ticket = (SingleUseTicket) nextTicket();
		if (SINGLE_USE_TICKETS.is(ticket) == SINGLE_USE_TICKETS.TICKET_120MINUTES)
			return (Ticket120minutes)ticket;
		return next();
	}
	
}
