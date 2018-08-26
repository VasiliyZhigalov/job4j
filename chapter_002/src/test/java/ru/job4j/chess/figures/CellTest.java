package ru.job4j.chess.figures;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CellTest {
    @Test
    /**
     * Проверка когда коордитаты ячеек не равны
     */
    public void whenCoodrNotEquals() {
        Cell source = Cell.getCell(1, 1);
        Cell dest = Cell.getCell(2, 1);
        boolean result = source.x == dest.x && source.y == dest.y;
        assertThat(result, is(false));
    }
}
