package it.unica.isw.ctm.tickets.observers;


import it.unica.isw.ctm.Wallet;

import java.util.Observable;
import java.util.Observer;


/**
 * Observe the change in tickets in a {@link Wallet}.
 */
public class TicketsObserver implements Observer {

    private int numTickets;


    public TicketsObserver(int numTickets) {
        this.numTickets = numTickets;
    }


    @Override
    public void update(Observable observable, Object o) {
        numTickets = ((Wallet)observable).getTickets().size();
    }

}
