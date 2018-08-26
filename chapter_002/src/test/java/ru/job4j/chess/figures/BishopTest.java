package ru.job4j.chess.figures;


import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {

    /**
     * Test to move bishop.
     */
    @Test
    public void whenMoveTwoStepCellX2() {
        Cell source = Cell.getCell(1, 1);
        Cell dest = Cell.getCell(4, 4);
        Bishop bishop = new Bishop(source);
        Cell[] way = new Cell[5];
        try {
            way = bishop.way(source, dest);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        }
        assertThat(way[0].x, is(2));
    }

}
