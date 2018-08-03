package ru.job4j.array;

public class Square {
    /**
     * заполняет массив квадратами последовательных чисел
     * @param bound
     * @return масив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}
