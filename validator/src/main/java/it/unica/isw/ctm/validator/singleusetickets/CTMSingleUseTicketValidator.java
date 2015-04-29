package it.unica.isw.ctm.validator.singleusetickets;


import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.validator.TicketValidator;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;


/**
 * CTM single-use ticket validator.
 */
public class CTMSingleUseTicketValidator extends AbstractSingleUseTicketValidator implements SingleUseTicketValidator {

	private static CTMSingleUseTicketValidator instance;
	private SingleUseTicketValidator next;
	
	
	/**
	 * Default constructor, no next is given.
	 */
	private CTMSingleUseTicketValidator() {
		next = null;
	}
	
	
	/**
	 * Create a CTMSingleUseTicketValidator with the {@code next}
	 * next.
	 * @param next	The next validator.
	 */
	private CTMSingleUseTicketValidator(SingleUseTicketValidator next) {
		this.next = next;
	}
	
	
	public static CTMSingleUseTicketValidator getInstance() {
		if (instance == null)
			instance = new CTMSingleUseTicketValidator();
		return instance;
	}
	
	
	@Override
	public void validate(Ticket ticket) throws Exception {
		if (canValidate(ticket))
			validate((SingleUseTicket) ticket);
		else {
			try {
				next.validate((SingleUseTicket)ticket);
			} catch(NullPointerException e) {
				throw new Exception("No validators found.");
			}
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(SingleUseTicket ticket) {
		if (ticket.isValidated())
			throw new AlreadyValidatedException(ticket.getId());
		
		if (canValidate(ticket)){
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
			ticket.setTimeStamp(expireDate);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canValidate(Ticket ticket) {
		if (TICKETS_KINDS.is(ticket) == TICKETS_KINDS.SINGLE_USE_TICKET
				&& ticket.getVendor() == VENDORS.CTM)
			return true;
		return false;
	}
	
	
	/**
	 * 
	 */
	@Override
	public TicketValidator getNext() throws NullPointerException {
		if (next == null)
			throw new NullPointerException("No next validator");
		return next;
	}

	
}