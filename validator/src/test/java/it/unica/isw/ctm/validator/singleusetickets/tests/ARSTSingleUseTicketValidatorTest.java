package it.unica.isw.ctm.validator.singleusetickets.tests;


import java.util.Calendar;

import org.junit.Test;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.exceptions.AlreadyValidatedException;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.validator.singleusetickets.ARSTSingleUseTicketValidator;
import it.unica.isw.ctm.validator.singleusetickets.CTMSingleUseTicketValidator;
import junit.framework.Assert;


public class ARSTSingleUseTicketValidatorTest {

	@Test
	public void testInstance() {
		Assert.assertNotNull(ARSTSingleUseTicketValidator.getInstance());
	}
	
	@Test
	public void testNext() {
		Assert.assertEquals(ARSTSingleUseTicketValidator.getInstance().getNext(), CTMSingleUseTicketValidator.getInstance());
	}
	
	@Test
	public void testValidateARST() throws Exception {
		SingleUseTicket ticket120 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		SingleUseTicket ticket90 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		
		Assert.assertFalse(ticket120.isValidated());
		Assert.assertFalse(ticket90.isValidated());
		
		ARSTSingleUseTicketValidator.getInstance().validate((Ticket)ticket90);
		ARSTSingleUseTicketValidator.getInstance().validate((Ticket)ticket120);
		
		Assert.assertTrue(ticket120.isValidated());
		Assert.assertTrue(ticket90.isValidated());
		
		System.out.println("[90] Ticket validated on: " + ticket90.getTimeStamp().get(Calendar.DAY_OF_MONTH) +
																						"/" + ticket90.getTimeStamp().get(Calendar.MONTH) + 
																						"/" + ticket90.getTimeStamp().get(Calendar.YEAR) +
																						" at " + ticket90.getTimeStamp().get(Calendar.HOUR_OF_DAY) +
																						":" + ticket90.getTimeStamp().get(Calendar.MINUTE) +
																						":" + ticket90.getTimeStamp().get(Calendar.SECOND));
		System.out.println("[90] Ticket expiring on: " + ticket90.getExpireDate().get(Calendar.DAY_OF_MONTH) +
																						"/" + ticket90.getExpireDate().get(Calendar.MONTH) + 
																						"/" + ticket90.getExpireDate().get(Calendar.YEAR) +
																						" at " + ticket90.getExpireDate().get(Calendar.HOUR_OF_DAY) +
																						":" + ticket90.getExpireDate().get(Calendar.MINUTE) +
																						":" + ticket90.getExpireDate().get(Calendar.SECOND));
		System.out.println("[120] Ticket validated on: " + ticket120.getTimeStamp().get(Calendar.DAY_OF_MONTH) +
																						"/" + ticket120.getTimeStamp().get(Calendar.MONTH) + 
																						"/" + ticket120.getTimeStamp().get(Calendar.YEAR) +
																						" at " + ticket120.getTimeStamp().get(Calendar.HOUR_OF_DAY) +
																						":" + ticket120.getTimeStamp().get(Calendar.MINUTE) +
																						":" + ticket120.getTimeStamp().get(Calendar.SECOND));
		System.out.println("[120] Ticket expiring on: " + ticket120.getExpireDate().get(Calendar.DAY_OF_MONTH) +
																						"/" + ticket120.getExpireDate().get(Calendar.MONTH) + 
																						"/" + ticket120.getExpireDate().get(Calendar.YEAR) +
																						" at " + ticket120.getExpireDate().get(Calendar.HOUR_OF_DAY) +
																						":" + ticket120.getExpireDate().get(Calendar.MINUTE) +
																						":" + ticket120.getExpireDate().get(Calendar.SECOND));
		try {
			ARSTSingleUseTicketValidator.getInstance().validate((Ticket)ticket90);
			ARSTSingleUseTicketValidator.getInstance().validate((Ticket)ticket120);
		} catch(AlreadyValidatedException e) {
			return;
		}
		
		throw new Exception();
	}
	
}
