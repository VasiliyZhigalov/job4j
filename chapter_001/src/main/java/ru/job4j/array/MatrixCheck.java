package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result1 = false;
        boolean result2 = false;
        int rows = data.length;
        for (int i = 1; i < rows; i++) {
            result1 = !(data[0][0] ^ data[i][i]);
            result2 = !(data[0][rows - 1] ^ data[i][rows - 1 - i]);
            if (!result1 || !result2) {
                break;
            }
        }
        return result1 && result2;
    }
}
