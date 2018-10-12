package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        int result = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            result = Integer.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() > minLength) {
            result = 1;
        } else if (result == 0 && right.length() > minLength) {
            result = -1;
        }
        return result;
    }
}