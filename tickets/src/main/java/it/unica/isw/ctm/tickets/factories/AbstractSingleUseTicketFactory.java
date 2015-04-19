package it.unica.isw.ctm.tickets.factories;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import it.unica.isw.ctm.tickets.singleusetickets.Ticket120minutes;
import it.unica.isw.ctm.tickets.singleusetickets.Ticket90minutes;


/**
 * Abstract interface for ticket generation.
 */
public abstract class AbstractSingleUseTicketFactory implements TicketFactory {	
	
	protected static final Set<Long> generatedTickets = new HashSet<Long>();
	protected static final Random randomGenerator = new Random();

	
	/**
	 * Generate a unique ID.
	 * @return		A unique id.
	 */
	protected final long generateId() {
		Long id = randomGenerator.nextLong();
		
		while(generatedTickets.contains(id))
			id = randomGenerator.nextLong();
		
		return id;
	}
	
	public abstract Ticket90minutes get90MinutesTicket();
	
	public abstract Ticket120minutes get120MinutesTicket();
	
}
