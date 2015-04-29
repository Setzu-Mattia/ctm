/**
 * Tickets collection.
 */
package it.unica.isw.ctm.tickets;


import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.tickets.exceptions.ValidationException;
import it.unica.isw.ctm.tickets.exceptions.info.NoValidationDateFoundException;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * A common ctm ticket that can only be validated <b>once</b>.
 */
public abstract class SingleUseTicket extends Ticket {
	
	/** The ticket expiration date. */
	protected Calendar expireDate;
	/** The ticket validation date. */
	protected Calendar timeStamp;
	private boolean validated;

	
	public boolean isValidated() {
		return validated;
	}


	public void setValidated(boolean validated) {
		if (this.validated)
			throw new AlreadyValidatedException(id);
		this.validated = validated;
	}


	/**
	 * Default ticket, expire date not set.
	 */
	public SingleUseTicket(VENDORS vendor, long id) {
		super(vendor, id);
		expireDate = defaultExpireDate;
		timeStamp = null;
		validated = false;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String validatedString = "";
		String expiredString = "";
		
		if (validated){
			validatedString = '\t' + "Validated on: " + timeStamp.toString();
			if(expireDate.compareTo(Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),
															new Locale("it", "IT"))) > 0)
				expiredString = "Expired on: " + expireDate;
			else
				expiredString = "Still valid, will expire on " + expireDate;
		}
			
		return (super.toString() + '\n' +
					'\t' + "Validated: " + validated + '\n' +
					'\t' + validatedString + '\n' + 
					'\t' + expiredString);
	}
	
	
	/**
	 * Get time stamp, if any.
	 * @return
	 */
	public Calendar getTimeStamp() {
		if (timeStamp == null)
			throw new NoValidationDateFoundException(id);
		return timeStamp;
	}

	
	public void setTimeStamp(Calendar timeStamp) throws AlreadyValidatedException {
		if (!validated)
			this.timeStamp = timeStamp;
		else
			throw new AlreadyValidatedException(id);
	}

	
	public Calendar getExpireDate() {
		return expireDate;
	}
	
	
	/**
	 * Validate this ticket.
	 * @throws Exception 
	 */
	public void validate(SingleUseTicket ticket) throws ValidationException {
		switch(SINGLE_USE_TICKETS.is(ticket)) {
			case TICKET_90MINUTES:
				throw new ValidationException(ticket.getId());
			case TICKET_120MINUTES:
				throw new ValidationException(ticket.getId());
		}
	}
	
	
}
