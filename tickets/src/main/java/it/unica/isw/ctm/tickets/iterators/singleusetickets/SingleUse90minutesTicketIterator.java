package it.unica.isw.ctm.tickets.iterators.singleusetickets;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;

import java.util.List;


/**
 * A iterator over {@link Ticket90minutes}s.
 */
public class SingleUse90minutesTicketIterator extends DefaultSingleUseTicketIterator<Ticket>
												implements SingleUseTicketIterator<Ticket90minutes> {

	public SingleUse90minutesTicketIterator(List<Ticket> collection) {
		super(collection, SINGLE_USE_TICKETS.TICKET_90MINUTES);
	}
	
}
