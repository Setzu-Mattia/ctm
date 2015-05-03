package it.unica.isw.ctm.tickets.observers;


import it.unica.isw.ctm.Wallet;
import it.unica.isw.ctm.tickets.Ticket;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;


/**
 * Observe the change in tickets in a {@link Wallet}.
 */
public class TicketsObserver implements Observer {

    private Collection<Ticket> currenTickets;

    public TicketsObserver(Collection<Ticket> currenTickets) {
        this.currenTickets = currenTickets;
    }


    @Override
    public void update(Observable observable, Object o) {
        Wallet observedWallet = (Wallet) observable;
        currenTickets = observedWallet.getTickets();
    }
}
