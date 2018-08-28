package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;


public class KnightWhite extends Figure {

        public KnightWhite(Cell position) {
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
            Cell[] steps = new Cell[] {dest};
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
            return new KnightWhite(dest);
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
            if (Math.abs(dest.x - source.x) == 2 && Math.abs(dest.y - source.y) == 1
                    || Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2
                    ) {
                return true;
            } else {
                throw new ImpossibleMoveException("invalid move");
            }
        }


}
