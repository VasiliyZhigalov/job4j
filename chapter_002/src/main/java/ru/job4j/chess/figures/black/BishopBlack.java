package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack extends Figure {
    public BishopBlack(Cell position) {
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
        int size = 0;
        int deltaX = 0;
        int deltaY = 0;
        deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        deltaY = (dest.y - source.y) > 0 ? 1 : -1;
        size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
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
        return new BishopBlack(dest);
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
    protected boolean wayIsValid(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            return true;
        } else {
            throw new ImpossibleMoveException("invalid move");
        }

    }
}