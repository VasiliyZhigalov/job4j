package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=tmp;
        }
        return array;
    }
}
