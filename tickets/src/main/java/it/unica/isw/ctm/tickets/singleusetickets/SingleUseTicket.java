/**
 * Tickets collection.
 */
package it.unica.isw.ctm.tickets.singleusetickets;


import it.unica.isw.ctm.tickets.TICKETS;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.tickets.exceptions.ValidationException;
import it.unica.isw.ctm.tickets.exceptions.info.NoValidationDateFoundException;

import java.util.Date;

/**
 * A common ctm ticket that can only be validated <b>once</b>.
 */
public abstract class SingleUseTicket extends Ticket {
	
	/** The ticket expiration date. */
	protected Date expireDate;
	/** The ticket validation date. */
	protected Date timeStamp;
	private boolean validated;

	
	/**
	 * Default ticket, expire date not set.
	 */
	public SingleUseTicket(long id) {
		super(id);
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
			if(expireDate.compareTo(new Date(System.currentTimeMillis())) > 0)
				expiredString = "Expired on: " + expireDate;
			else
				expiredString = "Still valid, will expire on " + expireDate;
		}
			
		return ("Ticket" + '\n'
					+ '\t' + "Type: SingleUseTicket" + '\n' +
					'\t' + "ID: " + id  + '\n' +
					'\t' + "Validated: " + validated + '\n' +
					'\t' + validatedString + '\n' + 
					'\t' + expiredString);
	}
	
	
	/**
	 * Get time stamp, if any.
	 * @return
	 */
	public Date getTimeStamp() {
		if (timeStamp == null)
			throw new NoValidationDateFoundException(id);
		return timeStamp;
	}

	
	public void setTimeStamp(Date timeStamp) throws AlreadyValidatedException {
		if (!validated)
			this.timeStamp = timeStamp;
		else
			throw new AlreadyValidatedException(id);
	}

	
	public Date getExpireDate() {
		return expireDate;
	}
	
	
	/**
	 * Validate this ticket.
	 * @throws Exception 
	 */
	public void validate(SingleUseTicket ticket) throws ValidationException {
		switch(TICKETS.is(ticket)) {
			case TICKET_90MINUTES:
				throw new ValidationException(ticket.getId());
			case TICKET_120MINUTES:
				throw new ValidationException(ticket.getId());
		}
	}
	
	
}