package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class CalcFunctionTest {
    @Test
    public void whenLinear() {
        CalcFunction calcFunction = new CalcFunction();
        List<Double> result = calcFunction.diapason(1, 5, x -> x);

        assertThat(result, is(Arrays.asList(1D, 2D, 3D, 4D)));
    }

    @Test
    public void whenQadratic() {
        CalcFunction calcFunction = new CalcFunction();
        List<Double> result = calcFunction.diapason(1, 5, x -> x * x);
        assertThat(result, is(Arrays.asList(1D, 4D, 9D, 16D)));
    }

    @Test
    public void whenLog() {
        CalcFunction calcFunction = new CalcFunction();
        List<Double> result = calcFunction.diapason(1, 5, Math::log);
        assertThat(result, is(Arrays.asList(Math.log(1D), Math.log(2), Math.log(3), Math.log(4))));
    }
}
