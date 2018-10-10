package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCalcTest {
    @Test
    public void when() {
        ArrayCalc calc = new ArrayCalc();

        int[] first = {1, 2, 5, 9};
        int[] second = {0, 2, 3, 5, 12};
        int[] result = calc.combiningArrays(first, second);
        int[] expect = {0, 1, 2, 2, 3, 5, 5, 9, 12};
        assertThat(result, is(expect));
    }
}