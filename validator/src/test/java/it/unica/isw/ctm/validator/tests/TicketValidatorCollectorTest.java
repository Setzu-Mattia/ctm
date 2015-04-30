package it.unica.isw.ctm.validator.tests;

import it.unica.isw.ctm.tickets.SingleUseTicket;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.validator.TicketValidator;
import it.unica.isw.ctm.validator.TicketValidatorCollector;
import junit.framework.Assert;

import org.junit.Test;

public class TicketValidatorCollectorTest {

	@Test
	public void testInstance() {
		Assert.assertNotNull(TicketValidatorCollector.getInstance());
	}
	
	@Test
	public void testValidation() {
		TicketValidator validator = TicketValidatorCollector.getInstance();
		
		SingleUseTicket arstTicket120 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		SingleUseTicket arstTicket90 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		SingleUseTicket ctmTicket120 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES);
		SingleUseTicket ctmTicket90 = (SingleUseTicket) DefaultSingleUseTicketsFactory.getInstance().getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES);
		
		Assert.assertTrue(TicketValidatorCollector.getInstance().canValidate(arstTicket120));
		Assert.assertTrue(TicketValidatorCollector.getInstance().canValidate(arstTicket90));
		Assert.assertTrue(TicketValidatorCollector.getInstance().canValidate(ctmTicket120));
		Assert.assertTrue(TicketValidatorCollector.getInstance().canValidate(ctmTicket90));
		
		validator.validate(ctmTicket90);
		validator.validate(ctmTicket120);
		validator.validate(arstTicket90);
		validator.validate(arstTicket120);
		
		Assert.assertTrue(ctmTicket90.isValidated());
		Assert.assertTrue(ctmTicket120.isValidated());
		Assert.assertTrue(arstTicket90.isValidated());
		Assert.assertTrue(arstTicket120.isValidated());
		
	}
	
}
