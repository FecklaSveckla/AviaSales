package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

public class TicketRepository {

    private Ticket[] items = new Ticket[0];


    public void save(Ticket item) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy( items, 0, tmp, 0, items.length );
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public Ticket[] getAll() {
        return items;
    }

    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }

        }
        return null;
    }


    public void removeById(int id) throws NotFoundException {
        if (findById( id ) == null) {
            throw new NotFoundException( "Element with id: " + id + " not found" );
        }
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}


