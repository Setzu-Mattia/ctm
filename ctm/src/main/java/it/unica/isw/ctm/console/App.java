package it.unica.isw.ctm.console;


import java.util.Collection;
import java.util.InputMismatchException;
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
	private static Scanner scanner = new Scanner(System.in);
	private static boolean exit = false; 
	
    public static void main( String[] args ) {
    	
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
	    				Wallet.getInstance().addTicket(((AbstractSingleUseTicketFactory)factory).get90MinutesTicket());
	    				break;
	    			case 3:
	    				Wallet.getInstance().addTicket(((AbstractSingleUseTicketFactory)factory).get120MinutesTicket());
	    				break;
	    			case 4:
	    				System.out.println("Exiting");
	    				exit = true;
	    				break;
	    		}	    		
    		} catch (InputMismatchException e) {
    			System.out.println("Not even a number, you dumb fuck.");
    		} finally {
    			scanner.nextLine();
    		}
    		
    	}
    	
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
    	System.out.println('\t' + "[2] Buy 90 minutes ticket.");
    	System.out.println('\t' + "[3] Buy 120 minutes ticket.");
    	System.out.println('\t' + "[4] Exit.");
    }
}
