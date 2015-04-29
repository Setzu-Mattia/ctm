package it.unica.isw.ctm.tickets;

import it.unica.isw.ctm.tickets.exceptions.ValidationException;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * A common ctm ticket.
 */
public abstract class Ticket {
	
	/** Random id */
	protected long id;
	protected static Calendar defaultExpireDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),
																		new Locale("it", "IT"));
	private VENDORS vendor;
	
	/**
	 * Default constructor. 
	 */
	public Ticket(VENDORS vendor, long id) {
		this.vendor = vendor;
		this.id = id;
	}
	
	
	/**
	 * Two tickets are equal iff thei have the same id.
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Ticket)
			return (this.getId() == ((Ticket)object).getId()
					&& this.getVendor() == ((Ticket)object).getVendor());
		return false;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return (new Long(id)).hashCode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return (vendor.name() + " Ticket" + '\n' + '\t' + "ID: " + id);
	}
	
	
	/**
	 * Get the ticket id.
	 * @return		The ticket's id.
	 */
	public long getId() {
		return id;
	}
	
	
	/**
	 * Get the ticket vendor.
	 * @return		The ticket vendor.
	 */
	public VENDORS getVendor() {
		return vendor;
	}
	
	
	/**
	 * Validate the ticket.
	 * @throws		ValidationException		In case there's been
	 * 										some problem with
	 * 										validation.
	 */
	public abstract void validate() throws ValidationException;
}
