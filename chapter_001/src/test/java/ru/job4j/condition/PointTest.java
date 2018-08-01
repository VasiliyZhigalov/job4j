package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(0, 0);
        double result = point1.distanceTo(point2);
        double expected = 5.0;
        assertThat(result, closeTo(expected, 0.1));
    }
}
