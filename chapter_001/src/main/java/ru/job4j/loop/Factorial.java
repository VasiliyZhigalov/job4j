package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int factorial = 1;
        if (n == 0) {
            factorial = 1;
        } else {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }
}

