package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Удаляет дубликаты из массива.
     * @param array
     * @return массив без дубликатов.
     */
    String[] remove(String[] array) {
        int dupliCounter = 0;
        String tmp;
        for (int i = 0; i < array.length - dupliCounter; i++) {
            for (int j = i + 1; j < array.length - dupliCounter; j++) {
                if (array[i].equals(array[j])) {
                    tmp = array[j];
                    array[j] = array[array.length - dupliCounter - 1];
                    array[array.length - dupliCounter - 1] = tmp;
                    dupliCounter++;
                    j--;
                }
            }

        }

        return Arrays.copyOf(array, array.length - dupliCounter);
    }
}
