package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class Board {
    Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    /**
     * Checks conditions
     * 1. checks valid for way
     * 2. found figure
     * 3. occupied way
     *
     * @param source starting position
     * @param dest   finishing position
     * @return
     */
    boolean move(Cell source, Cell dest) {
        if (source.x == dest.x && source.y == dest.y) {
            return false;
        } else {
            try {
                int pos = this.findIndexFigureByCell(source);
                Cell[] way = this.figures[pos].way(source, dest);
                this.wayIsOccupied(way);
                this.figures[pos] = this.figures[pos].copy(dest);
            } catch (ImpossibleMoveException ime) {
                System.out.println(ime.getMessage());
                return false;
            } catch (FigureNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
                return false;
            } catch (OccupiedWayException owe) {
                System.out.println(owe.getMessage());
                return false;
            }
            return true;
        }
    }

    /**
     * check occupied cell in way
     *
     * @param way
     * @return
     * @throws OccupiedWayException
     */
    public boolean wayIsOccupied(Cell[] way) throws OccupiedWayException {
        for (int i = 0; i < this.index; i++) {
            for (Cell step : way) {
                if (this.figures[i].position().equals(step)) {
                    throw new OccupiedWayException("Way is occupied");
                }
            }
        }
        return false;
    }

    /**
     * Find index in figures array.
     *
     * @param source
     * @return
     * @throws FigureNotFoundException
     */
    private int findIndexFigureByCell(Cell source) throws FigureNotFoundException {
        int result = -1;
        for (int i = 0; i < this.index; i++) {
            if (this.figures[i].position().equals(source)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new FigureNotFoundException("Figure not found");
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
}
