package it.unica.isw.ctm.validator.singleusetickets.tests;


import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.validator.singleusetickets.CTMSingleUseTicketValidator;
import org.junit.Test;

import static junit.framework.Assert.*;


public class CTMSingleUseTicketValidatorTest {

	@Test
	public void testInstance() {
		assertNotNull(CTMSingleUseTicketValidator.getInstance());
	}
	
	@Test
	public void testNext() {
		try {
			assertEquals(CTMSingleUseTicketValidator.getInstance().getNext(), null);
		} catch(NullPointerException e) {
			return;
		}
	}
	
	@Test
	public void testValidateCTM() throws Exception {
		SingleUseTicket ticket120 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		SingleUseTicket ticket90 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		
		assertFalse(ticket120.isValidated());
		assertFalse(ticket90.isValidated());
		
		CTMSingleUseTicketValidator.getInstance().validate((Ticket) ticket90);
		CTMSingleUseTicketValidator.getInstance().validate((Ticket) ticket120);
		
		assertTrue(ticket120.isValidated());
		assertTrue(ticket90.isValidated());

		try {
			CTMSingleUseTicketValidator.getInstance().validate((Ticket)ticket90);
			CTMSingleUseTicketValidator.getInstance().validate((Ticket)ticket120);
		} catch(AlreadyValidatedException e) {
			return;
		}
		
		throw new Exception();
	}

	
}
