package ctm.it.unica.isw.ctm;


import java.util.Collection;
import java.util.Scanner;

import it.unica.isw.ctm.Wallet;
import it.unica.isw.ctm.tickets.Ticket;
import it.unica.isw.ctm.tickets.factories.AbstractSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.factories.DefaultSingleUseTicketFactory;
import it.unica.isw.ctm.tickets.factories.TicketFactory;


/**
 * Console application.
 */
public class App {
	
	private static TicketFactory factory = new DefaultSingleUseTicketFactory();
	private static Wallet wallet = new Wallet();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean exit = false; 
	
    public static void main( String[] args ) {
    	int currentChoice = -1;
    	while(!exit) {
    		printMenu();
    		currentChoice = scanner.nextInt();
    		
    		switch (currentChoice) {
    			case 0:
    				printTickets(wallet.getTickets());
    				break;
    			case 1:
    				wallet.addTicket(((AbstractSingleUseTicketFactory)factory).get90MinutesTicket());
    				break;
    			case 2:
    				wallet.addTicket(((AbstractSingleUseTicketFactory)factory).get120MinutesTicket());
    				break;
				default:
					System.out.println(currentChoice + " pressed, aborting.");
    				exit = true;
    				break;
    		}
    	}
    }
    
    /**
     * List tickets in wallet.
     */
    private static void printTickets(Collection<Ticket> tickets) {
    	for (Ticket current : tickets)
    		System.out.println('\t' + current.toString());
    	
    	System.out.println('\n' + "* No more tickets available.");
    }
    
    /**
     * Print menu.
     */
    private static void printMenu() {
    	System.out.println("CTM App menu");
    	System.out.println("Select an option below:");
    	System.out.println('\t' + "[0] List tickets");
    	System.out.println('\t' + "[1] Buy 90 minutes ticket.");
    	System.out.println('\t' + "[2] Buy 120 minutes ticket.");
    	System.out.println('\t' + "[3] Exit.");
    }
}
