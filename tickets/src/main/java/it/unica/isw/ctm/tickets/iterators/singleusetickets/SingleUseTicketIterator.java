package it.unica.isw.ctm.tickets.iterators.singleusetickets;


import it.unica.isw.ctm.tickets.SingleUseTicket;

import java.util.Iterator;


/**
 * A iterator over {@link SingleUseTicket}s.
 */
public interface SingleUseTicketIterator<T extends SingleUseTicket>
											extends Iterator<SingleUseTicket> {}