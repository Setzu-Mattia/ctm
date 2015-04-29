package it.unica.isw.ctm.console;


import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import it.unica.isw.ctm.Wallet;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractTicketFactory;
import it.unica.isw.ctm.tickets.factories.TicketFactory;
import it.unica.isw.ctm.tickets.kinds.SINGLE_USE_TICKETS;
import it.unica.isw.ctm.tickets.vendors.VENDORS;


/**
 * Console application.
 */
public class App {
	
	private static TicketFactory factory = AbstractTicketFactory.getInstance();
	 
	
    public static void main( String[] args ) {
    	Scanner scanner = new Scanner(System.in);
    	boolean exit = false;
    	int currentChoice = 0;
    	
    	while(!exit) {
    		
    		try{
    			printMenu();
	    		currentChoice = scanner.nextInt();
	    		
	    		switch (currentChoice) {
	    			case 0:
	    				continue;
	    			case 1:
	    				printTickets(Wallet.getInstance().getTickets());
	    				break;
	    			case 2:
	    				Wallet.getInstance().addTicket(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_90MINUTES));
	    				break;
	    			case 3:
	    				Wallet.getInstance().addTicket(factory.getTicket(VENDORS.CTM, SINGLE_USE_TICKETS.TICKET_120MINUTES));
	    				break;
	    			case 4:
	    				Wallet.getInstance().addTicket(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_90MINUTES));
	    				break;
	    			case 5:
	    				Wallet.getInstance().addTicket(factory.getTicket(VENDORS.ARST, SINGLE_USE_TICKETS.TICKET_120MINUTES));
	    				break;
	    			case 6:
	    				exit = true;
	    				break;
	    		}	    		
    		} catch (InputMismatchException e) {
    			System.out.println("Not even a number, you dumb fuck.");
    		} finally {
    			scanner.nextLine();
    		}
    		
    	}
    	
    	scanner.close();
    }
    
    /**
     * List tickets in wallet.
     */
    private static void printTickets(Collection<Ticket> tickets) {
    	for (Ticket current : tickets)
    		System.out.println('\t' + current.toString() + '\n');
    	
    	System.out.println('\n' + "* No more tickets available.");
    }
    
    /**
     * Print menu.
     */
    private static void printMenu() {
    	System.out.println("CTM App menu");
    	System.out.println("Select an option below:");
    	
    	System.out.println('\t' + "[1] List tickets");
    	System.out.println('\t' + "[-] CTM ticket.");
    		System.out.println('\t' + " " + '\t' + "[2] Buy 90 minutes ticket");
    		System.out.println('\t' + " " + '\t' + "[3] Buy 120 minutes ticket.");
    		
    	System.out.println('\t' + "[-] ARST ticket.");
    		System.out.println('\t' + " " + '\t' + "[4] Buy 90 minutes ticket");
    		System.out.println('\t' + " " + '\t' + "[5] Buy 120 minutes ticket.");
    		
    	System.out.println('\t' + "[6] Exit.");
    }
}
