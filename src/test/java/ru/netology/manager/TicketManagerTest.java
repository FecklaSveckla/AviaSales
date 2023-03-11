package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager( repository );
    private Ticket first = new Ticket( 1, 1000, "AAA", "AAB", 100 );
    private Ticket second = new Ticket( 2, 2000, "AAC", "AAE", 200 );
    private Ticket third = new Ticket( 3, 3000, "AAA", "AAB", 300 );
    private Ticket four = new Ticket( 4, 1500, "AAH", "AAI", 150 );
    private Ticket five = new Ticket( 5, 4000, "AAJ", "AAK", 250 );
    private Ticket six = new Ticket( 6, 2500, "AAA", "AAB", 350 );

    @BeforeEach
    public void setUp() {

        manager.save( first );
        manager.save( second );
        manager.save( third );
        manager.save( four );
        manager.save( five );
        manager.save( six );
    }

    @Test
    void shouldShowOffers() {
        Ticket[] expected = new Ticket[]{first, four, second, six, third, five};
        assertArrayEquals( expected, manager.showOffers() );
    }

    @Test
    void shouldSearchIfExists() {
        Ticket[] expected = new Ticket[]{first, six, third};
        assertArrayEquals( expected, manager.findAll( "AAA", "AAB" ) );
    }


    @Test
    void shouldSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals( expected, manager.findAll( "AAA", "AAJ" ) );

    }


}