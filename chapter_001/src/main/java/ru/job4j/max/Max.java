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
}
