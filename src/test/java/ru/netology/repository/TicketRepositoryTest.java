package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();

    private Ticket first = new Ticket( 1, 1000, "AAA", "AAB", 100 );
    private Ticket second = new Ticket( 2, 2000, "AAC", "AAE", 200 );
    private Ticket third = new Ticket( 3, 3000, "AAA", "AAB", 300 );
    private Ticket four = new Ticket( 4, 1500, "AAH", "AAI", 150 );
    private Ticket five = new Ticket( 5, 4000, "AAJ", "AAK", 250 );
    private Ticket six = new Ticket( 6, 2500, "AAA", "AAB", 350 );


    @Test
    void shouldSave() {
        repository.save( first );
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.getAll();
        assertArrayEquals( expected, actual );
    }

    @Test
    void shouldShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals( expected, actual );
    }

    @Test
    void shouldShowNotEmpty() {
        repository.save( first );
        repository.save( second );
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals( expected, actual );
    }

    @Test
    public void shouldFinById() {
        repository.save( second );
        repository.findById( second.getId() );

        Ticket[] expected = {second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals( expected, actual );

    }

    @Test
    public void shouldRemoveId() {
        repository.save( first );
        repository.save( second );
        repository.save( third );
        repository.removeById( second.getId() );
        Ticket[] expected = {first, third};
        Ticket[] actual = repository.getAll();
        assertArrayEquals( expected, actual );
    }

    @Test
    public void removeByIdElementNotExistTest() {

        assertThrows( NotFoundException.class, () -> repository.removeById( 7 ) );
    }

}
