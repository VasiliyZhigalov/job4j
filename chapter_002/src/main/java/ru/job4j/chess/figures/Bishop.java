package ru.job4j.chess.figures;

import ru.job4j.chess.*;

import java.util.Objects;


public class Bishop implements Figure {
    /**
     * Bishop position/
     */
    private final Cell position;

    public Bishop(Cell position) {
        this.position = position;
    }


    /**
     * get position
     *
     * @return
     */
    public Cell position() {
        return this.position;
    }

    /**
     * possible path array
     *
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        this.wayIsValid(source, dest);
        int size = (int) Math.sqrt(Math.pow((dest.x - source.x), 2) + Math.pow((dest.y - source.y), 2));
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) / Math.abs(dest.x - source.x);
        int deltaY = (dest.y - source.y) / Math.abs(dest.y - source.y);
        int currentX = source.x + deltaX;
        int currentY = source.y + deltaY;
        for (int index = 1; index <= size; index++) {
            steps[index - 1] = Cell.getCell(currentX, currentY);
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
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    /**
     * checks for a way
     *
     * @param source starting position
     * @param dest   finishing position
     * @return
     * @throws ImpossibleMoveException
     */
    private boolean wayIsValid(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(dest.x - source.x) != Math.abs(dest.y - source.y)) {
            throw new ImpossibleMoveException("invalid move");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bishop bishop = (Bishop) o;
        return this.position == bishop.position;
    }

    @Override
    public int hashCode() {

        return Objects.hash(position);
    }
}
