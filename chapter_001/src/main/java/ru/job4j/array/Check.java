package ru.job4j.array;

public class Check {
    /**
     * Массив заполнен true или false.
     * @param data
     * @return true если массив заполнен одинаковыми значениями.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 1; index < data.length; index++) {
            result = !(data[0] ^ data[index]);
            if (!result) {
                break;
            }
        }
        return result;
    }
}
