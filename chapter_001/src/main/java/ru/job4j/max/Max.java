package ru.job4j.max;

/**
 * @author  Vasiliy Zhigalov
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Возращает максимум из двух целых чисел
     * @param first
     * @param second
     * @return максимум
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Возращает максимум из трех чисел
     * @param first
     * @param second
     * @param third
     * @return
     */
    public int max(int first, int second, int third) {
        int result;
        result = this.max(first, second);
        result = this.max(result, third);
        return result;
    }
}
