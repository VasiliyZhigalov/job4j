package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenAddFigure() {
        Board board = new Board();
        Cell source = Cell.getCell(1, 1);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        assertThat(board.figures[0].position().y, is(1));
    }

    @Test
    public void whenCellIsOccupied() {
        Cell cell1 = Cell.getCell(1, 1);
        Cell cell2 = Cell.getCell(2, 2);
        Cell cell3 = Cell.getCell(3, 3);
        Cell cell4 = Cell.getCell(2, 2);
        Board board = new Board();
        board.add(new Bishop(cell3));
        Cell[] cells = new Cell[3];
        cells[0] = cell1;
        cells[1] = cell2;
        cells[2] = cell3;
        boolean result = true;
        System.out.println(cells.length);
        try {
            result = board.wayIsOccupied(cells);
        } catch (OccupiedWayException e) {
            System.out.println("Исключение");
        }
        assertThat(result, is(true));
    }

}
