package it.unica.isw.ctm.tickets.iterators.singleusetickets;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.iterators.DefaultTicketIterator;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * A iterator over {@link SingleUseTicket}s.
 */
public class DefaultSingleUseTicketIterator<T> extends DefaultTicketIterator<Ticket>
                                                implements Iterator<SingleUseTicket> {

    protected SINGLE_USE_TICKETS singleUseTicketKind;

    public DefaultSingleUseTicketIterator(List<Ticket> collection, SINGLE_USE_TICKETS kind) {
        super(collection, TICKETS_KINDS.SINGLE_USE_TICKET);
        singleUseTicketKind = kind;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected final int findNext(int current, int to) throws NullPointerException {
        int i = super.findNext(current, to);
        if (TICKETS_KINDS.is(collection.get(i)) == TICKETS_KINDS.SINGLE_USE_TICKET
            && SINGLE_USE_TICKETS.is((SingleUseTicket)collection.get(i)) == singleUseTicketKind)
            return i;
        return findNext(i + 1, to);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        try {
            findNext(position, collection.size());
            return true;
        } catch(NullPointerException e) {
            return false;
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public SingleUseTicket next() {
        try {
            position = findNext(position, collection.size()) + 1;
            return (SingleUseTicket) collection.get(position - 1);
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }
    }

}