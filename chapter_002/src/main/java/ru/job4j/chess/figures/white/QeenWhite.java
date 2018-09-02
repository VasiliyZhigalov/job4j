package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.QeenBlack;

public class QeenWhite extends Figure {
    public QeenWhite(Cell position) {
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
        if (dest.x == source.x) {
            deltaY = (dest.y - source.y) > 0 ? 1 : -1;
            size = Math.abs(dest.y - source.y);
        } else if (dest.y == source.y) {
            deltaX = (dest.x - source.x) > 0 ? 1 : -1;
            size = Math.abs(dest.x - source.x);
        } else {
            deltaX = (dest.x - source.x) > 0 ? 1 : -1;
            deltaY = (dest.y - source.y) > 0 ? 1 : -1;
            size = Math.abs(dest.x - source.x);
        }
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
        return new QeenWhite(dest);
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
        if (Math.abs(dest.x - source.x) != Math.abs(dest.y - source.y)
                && Math.abs(dest.x - source.x) != 0 && Math.abs(dest.y - source.y) != 0
                ) {
            throw new ImpossibleMoveException("invalid move");
        }
        return true;
    }

}
