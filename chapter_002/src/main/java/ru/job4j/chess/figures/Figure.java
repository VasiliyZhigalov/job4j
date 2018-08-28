package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.black.BishopBlack;

import java.util.Objects;

public abstract class Figure {
    private final Cell position;

    protected Figure(Cell position) {
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


    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    protected abstract boolean wayIsValid(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure figure = (Figure) o;
        return this.position == figure.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
