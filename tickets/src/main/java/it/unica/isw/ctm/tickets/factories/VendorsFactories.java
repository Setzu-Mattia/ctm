package it.unica.isw.ctm.tickets.factories;


import it.unica.isw.ctm.tickets.kinds.TICKETS_KINDS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;
import it.unica.isw.ctm.tickets.vendors.factories.ARSTSingleUseTicketsFactory;
import it.unica.isw.ctm.tickets.vendors.factories.CTMSingleUseTicketsFactory;

import java.util.HashMap;
import java.util.Map;


public class VendorsFactories {

	private static VendorsFactories instance;
	private static Map<VENDORS, Map<TICKETS_KINDS, TicketFactory>> vendorsMap;
	
	
	private VendorsFactories() {
		vendorsMap = new HashMap<VENDORS, Map<TICKETS_KINDS, TicketFactory>>();
		HashMap<TICKETS_KINDS, TicketFactory> CTMticketsMap = new HashMap<TICKETS_KINDS, TicketFactory>();
		HashMap<TICKETS_KINDS, TicketFactory> ARSTticketsMap = new HashMap<TICKETS_KINDS, TicketFactory>();
		
		ARSTticketsMap.put(TICKETS_KINDS.SINGLE_USE_TICKET, ARSTSingleUseTicketsFactory.getInstance());
		CTMticketsMap.put(TICKETS_KINDS.SINGLE_USE_TICKET, CTMSingleUseTicketsFactory.getInstance());
		
		vendorsMap.put(VENDORS.CTM, CTMticketsMap);
		vendorsMap.put(VENDORS.ARST, ARSTticketsMap);		
	}
	
	
	/**
	 * Get the VendorsFactory instance.
	 * @return		The VendorsFactory instance.
	 */
	public static VendorsFactories getInstance() {
		if (instance == null)
			instance = new VendorsFactories();
		return instance;
	}
	
	
	/**
	 * Get the {@link vendor}'s factory for the given {@link kind}.
	 * @param vendor	The requested vendor.
	 * @param kind		The requested kind.
	 * @return			The {@link vendor}'s factory for the given {@link kind}.
	 */
	public TicketFactory getTicketFactory(VENDORS vendor, TICKETS_KINDS kind) {
		return vendorsMap.get(vendor).get(kind);
	}
	
}
