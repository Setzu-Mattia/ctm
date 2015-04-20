package it.unica.isw.ctm.tickets.factories;

import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class VendorsFactories {

	private static VendorsFactories instance;
	private static Map<VENDORS,Collection<TicketFactory>> vendorsMap;
	private static Map<SINGLE_USE_TICKETS, TicketFactory> factoriesMap;
	
	
	private VendorsFactories() {
		vendorsMap = new HashMap<VENDORS,Collection<TicketFactory>>();
		factoriesMap = new HashMap<SINGLE_USE_TICKETS, TicketFactory>();
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
	 * Get the tickets factories of the given {@link vendor}.
	 * @param vendor	The vendor.
	 * @return			The tickets factories of the given {@link vendor}.
	 */
	private Collection<TicketFactory> getTicketsFactories(VENDORS vendor) {
		return vendorsMap.get(vendor);
	}
	
	
	/**
	 * Get the tickets factories of the given {@link vendor}.
	 * @param vendor	The vendor.
	 * @return			The tickets factories of the given {@link vendor}.
	 */
	public TicketFactory getTicketFactory(VENDORS vendor) {
		return factoriesMap.get(vendor);
	}
	
}
