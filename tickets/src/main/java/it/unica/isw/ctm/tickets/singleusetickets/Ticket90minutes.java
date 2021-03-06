package it.unica.isw.ctm.tickets.singleusetickets;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Ticket active for 90 minutes from its validation.
 */
public class Ticket90minutes extends SingleUseTicket {

	public Ticket90minutes(VENDORS vendor, long id) {
		super(vendor, id);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + '\t' + "** - 90 minutes ticket";
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate() {
		super.validate(this);
	}
	
}