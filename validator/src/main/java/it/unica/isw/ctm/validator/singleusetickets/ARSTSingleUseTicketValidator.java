package it.unica.isw.ctm.validator.singleusetickets;


import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.validator.exceptions.NoSuitableValidatorException;


/**
 * ARST single use ticket validator.
 */
public class ARSTSingleUseTicketValidator extends AbstractSingleUseTicketValidator implements SingleUseTicketValidator {

	private static ARSTSingleUseTicketValidator instance;
	private SingleUseTicketValidator next;
	
	
	/**
	 * Create a ARSTSingleUseTicketValidator with the {@code next}
	 * next.
	 * @param next	The next validator.
	 */
	private ARSTSingleUseTicketValidator(SingleUseTicketValidator next) {
		this.next = next;
	}
	
	public static ARSTSingleUseTicketValidator getInstance() {
		if (instance == null)
			instance = new ARSTSingleUseTicketValidator(CTMSingleUseTicketValidator.getInstance());
		return instance;
	}
	
	
	@Override
	public void validate(Ticket ticket) throws NoSuitableValidatorException {
		if (canValidate(ticket))
			validate((SingleUseTicket) ticket);
		else if (next != null)
			next.validate(ticket);
		else
			throw new NoSuitableValidatorException(ticket);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(SingleUseTicket ticket) throws AlreadyValidatedException {
		if (ticket.isValidated())
			throw new AlreadyValidatedException(ticket.getId());
		
		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),
											new Locale("it", "IT"));
		Calendar expireDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),
											new Locale("it", "IT"));
		
		switch(SINGLE_USE_TICKETS.is((SingleUseTicket)ticket)) {
			case TICKET_120MINUTES:
				expireDate.add(Calendar.MINUTE, 120);
				break;
			case TICKET_90MINUTES:
				expireDate.add(Calendar.MINUTE, 90);
				break;				
		}
		
		ticket.setTimeStamp(now);
		ticket.setExpireDate(expireDate);
		ticket.setValidated(true);
		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		if (TICKETS_KINDS.is(ticket) == TICKETS_KINDS.SINGLE_USE_TICKET
				&& ticket.getVendor() == VENDORS.ARST)
			return true;
		return false;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SingleUseTicketValidator getNext() throws NullPointerException {
		return next;
	}

}
