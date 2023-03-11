package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    TicketRepository repository;


    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void save(Ticket item) {
        repository.save( item );
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getDeparture().equalsIgnoreCase( from ) && ticket.getArrival().equalsIgnoreCase( to )) {
                Ticket[] tmp = new Ticket[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy( result, 0, tmp, 0, result.length );
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort( result );
        return result;
    }

    public Ticket[] showOffers() {
        Ticket[] result = repository.getAll();
        Arrays.sort( result );
        return result;
    }


}




