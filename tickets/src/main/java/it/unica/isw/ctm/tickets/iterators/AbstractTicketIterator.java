package it.unica.isw.ctm.tickets.iterators;


import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * A iterator over {@link Ticket}s.
 */
public abstract class AbstractTicketIterator<T extends Ticket> {

	protected TICKETS_KINDS kind;
	protected List<T> collection;
	protected int position;
	
	public AbstractTicketIterator() {
		position = 0;
		collection = new ArrayList<T>();
	}
	
	public AbstractTicketIterator(List<T> collection, TICKETS_KINDS kind) {
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
	 * @param		kind					The kind of ticket to find.
	 * @param		i						The start index.
	 * @param		to						The upper limit of search.
	 * @return								The index of next element.
	 * @throws		NullPointerException 	If no
	 * 										such element is found.
	 */
	private int findNext(int current, int to) throws NullPointerException {
		System.out.println("findNext(" + current +", " + to + ")");
		if (current >= to){
			System.out.println("throwing nullpointer...");
			throw new NullPointerException("No next element of kind: " + kind.name());
		}
		
		if (TICKETS_KINDS.is(collection.get(current)) == kind)
			return current;
		else{
			current++;
			System.out.println("Calling with: " + current + ", " + to);
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
		System.out.println("In hasNextTicket(" + current + ", " + to + ")");
		try {
			if (findNext(current, to) >= position)
				return true;
			return false;
		} catch(NullPointerException e) {
			System.out.println("No next ticket");
			return false;
		}
	}
	
	
	/**
	 * Get the next ticket of the given kind.
	 * @param kind		The ticket kind.
	 * @return		 	The ticket of the given kind,
	 * 					if present. null otherwise.
	 */
	protected Ticket nextTicket() throws NoSuchElementException {
		try {
			System.out.println("abstract... next()");
			int foundIndex = findNext(position, collection.size());
			System.out.println("Next found in position: " + position);
			position = foundIndex + 1;
			return collection.get(foundIndex);
		} catch (NullPointerException e) {
			throw new NoSuchElementException();
		}
	}
	

	public final void remove() {
		collection.remove(position--);
	}
	
}