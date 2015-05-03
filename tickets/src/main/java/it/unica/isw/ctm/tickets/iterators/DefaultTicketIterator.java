package it.unica.isw.ctm.tickets.iterators;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * A iterator over {@link Ticket}s.
 */
public class DefaultTicketIterator<T extends Ticket> {

	protected TICKETS_KINDS kind;
	protected List<Ticket> collection;
	protected int position;
	
	public DefaultTicketIterator() {
		position = 0;
		collection = new ArrayList<Ticket>();
	}
	
	public DefaultTicketIterator(List<Ticket> collection, TICKETS_KINDS kind) {
		this.collection = collection;
		this.kind = kind;
	}
	
	/**
	 * Reset index position.
	 */
	private void reset() {
		position = 0;
	}


	/**
	 * Find next element.
	 * @param		current				The start index.
	 * @param		to						The upper limit of search.
	 * @return								The index of next element.
	 * @throws		NullPointerException If no 	such element is found.
	 */
	protected int findNext(int current, int to) throws NullPointerException {
		if (current >= to)
			throw new NullPointerException("No next element of kind: " + kind.name());
		
		if (TICKETS_KINDS.is(collection.get(current)) == kind)
			return current;
		else{
			current++;
			return findNext(current, to);
		}
	}
	
	
	/**
	 * Check if collection has a next element.
	 * @param current	The start index for search.
	 * @param to		The end index for search.
	 * 					Not necessarly the last index
	 * 					of the collection.
	 * @return			True if has a next proper
	 * 					element, false otherwise.
	 */
	protected final boolean hasNextTicket(int current, int to) {
		try {
			return findNext(current, to) >= position;
		} catch(NullPointerException e) {
			return false;
		}
	}
	
	
	/**
	 * Get the next ticket of the given kind.
	 * @return		 	The ticket of the given kind,
	 * 					if present. null otherwise.
	 */
	protected T nextTicket() throws NoSuchElementException {
		try {
			position = findNext(position, collection.size()) + 1;
			return (T) collection.get(position - 1);
		} catch (NullPointerException e) {
			throw new NoSuchElementException();
		}
	}
	

	public final void remove() {
		collection.remove(position--);
	}
	
}