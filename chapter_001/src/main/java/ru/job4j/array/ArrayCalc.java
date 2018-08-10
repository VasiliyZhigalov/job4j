package ru.job4j.array;

public class ArrayCalc {
    /**
     * Объединяет два массива отсортированных по возрастанию в один отсортированный по возрастанию.
     * @param first массив отсортированный по возрастанию.
     * @param second массив отсортированный по возрастанию.
     * @return массив отсортированный по возрастанию.
     */
    public int[] combiningArrays(int[] first, int[] second) {
        int length = first.length + second.length;
        int[] result = new int[length];
        int indexFirst = 0;
        int indexSecond = 0;
        int index = 0;
        while (indexFirst < first.length && indexSecond < second.length) {
            if (first[indexFirst] <= second[indexSecond]) {
                result[index] = first[indexFirst];
                indexFirst++;
            } else {
                result[index] = second[indexSecond];
                indexSecond++;
            }
            index++;
        }
        while (indexFirst < first.length) {
            result[index] = first[indexFirst];
            indexFirst++;
            index++;
        }
        while (indexSecond < second.length) {
            result[index] = second[indexSecond];
            indexSecond++;
            index++;
        }
        return result;
    }
}
