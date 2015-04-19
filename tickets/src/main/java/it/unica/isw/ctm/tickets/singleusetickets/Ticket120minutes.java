package it.unica.isw.ctm.tickets.singleusetickets;

import it.unica.isw.ctm.tickets.exceptions.ValidationException;


/**
 * Ticket valid for 120 minutes.
 */
public class Ticket120minutes extends SingleUseTicket {

	public Ticket120minutes(long id) {
		super(id);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + '\t' + "** - 120 minutes ticket";
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate() throws ValidationException {
		super.validate(this);
	}
	
}