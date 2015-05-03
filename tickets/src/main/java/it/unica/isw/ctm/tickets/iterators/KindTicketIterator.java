package it.unica.isw.ctm.tickets.iterators;

import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator over a {@link TICKETS_KINDS}.
 */
public class KindTicketIterator<T extends Ticket> extends DefaultTicketIterator<T>
                                        implements Iterator<T> {

    public KindTicketIterator(List<Ticket> collection, TICKETS_KINDS kind) {
        super(collection, kind);
    }


    public boolean hasNext() {
        return hasNextTicket(position, collection.size());
    }


    public T next() {
        return nextTicket();
    }

}
