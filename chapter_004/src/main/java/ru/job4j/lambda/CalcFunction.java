package ru.job4j.lambda;

import java.util.LinkedList;
import java.util.function.Function;
import java.util.List;

public class CalcFunction {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new LinkedList<>();
        for (int index = start; index < end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
