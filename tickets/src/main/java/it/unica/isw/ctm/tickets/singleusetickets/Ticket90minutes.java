package it.unica.isw.ctm.tickets.singleusetickets;


/**
 * Ticket active for 90 minutes from its validation.
 */
public class Ticket90minutes extends SingleUseTicket {

	public Ticket90minutes(long id) {
		super(id);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + 'n' + '\t' + '\t' + "90 minutes ticket";
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate() {
		super.validate(this);
	}
	
}