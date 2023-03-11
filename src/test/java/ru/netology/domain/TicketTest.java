package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private TicketRepository repository = new TicketRepository();

    private Ticket first = new Ticket( 1, 1000, "AAA", "AAB", 100 );
    private Ticket second = new Ticket( 2, 2000, "AAC", "AAE", 200 );
    private Ticket third = new Ticket( 3, 3000, "AAA", "AAB", 300 );
    private Ticket five = new Ticket( 5, 1500, "AAH", "AAI", 150 );
    private Ticket ten = new Ticket( 10, 4000, "AAJ", "AAK", 250 );
    private Ticket seven = new Ticket( 7, 4000, "AAA", "AAB", 350 );

    @Test
    void compareToCheaper() {
        int expected = -1;

        int actual = first.compareTo( second );

        assertEquals( expected, actual );
    }

    @Test
    void compareToMoreExpensive() {
        int expected = 1;

        int actual = third.compareTo( five);

        assertEquals( expected, actual );
    }


    @Test
    void compareToSameCost() {
        int expected = 0;

        int actual = ten.compareTo( seven );

        assertEquals( expected, actual );
    }

}









