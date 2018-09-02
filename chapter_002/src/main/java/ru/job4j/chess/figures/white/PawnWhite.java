package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.PawnBlack;

public class PawnWhite extends Figure {
    public PawnWhite(Cell position) {
        super(position);
    }

    /**
     * possible path array
     *
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        this.wayIsValid(source, dest);
        int size = 1;
        Cell[] steps = new Cell[size];
        int deltaX = 0;
        int deltaY = 1;
        int currentX = source.x + deltaX;
        int currentY = source.y + deltaY;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.getCell(currentX, currentY);
            currentX += deltaX;
            currentY += deltaY;
        }
        return steps;
    }

    /**
     * Copy figure
     *
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }

    /**
     * checks for a way
     *
     * @param source starting position
     * @param dest   finishing position
     * @return
     * @throws ImpossibleMoveException
     */
    @Override
    public boolean wayIsValid(Cell source, Cell dest) throws ImpossibleMoveException {
        if (dest.x - source.x != 0 || dest.y - source.y != 1) {
            throw new ImpossibleMoveException("invalid move");
        }
        return true;
    }
}
