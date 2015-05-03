package it.unica.isw.ctm.tickets.iterators.singleusetickets;

import java.util.Iterator;
import java.util.List;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.iterators.AbstractTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;


/**
 * A iterator over {@link Ticket90minutes}s.
 */
public class SingleUse90minutesTicketIterator extends AbstractTicketIterator<Ticket>
												implements Iterator<Ticket90minutes> {
	
	public SingleUse90minutesTicketIterator(List<Ticket> collection) {
		super(collection, TICKETS_KINDS.SINGLE_USE_TICKET);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return super.hasNextTicket(position, collection.size());
	}
	
	
	public Ticket90minutes next() {
		SingleUseTicket ticket = (SingleUseTicket) super.nextTicket();
		if (SINGLE_USE_TICKETS.is(ticket) == SINGLE_USE_TICKETS.TICKET_90MINUTES)
			return (Ticket90minutes)ticket;
		return next();
	}
	
}
