package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int indexRow;
        int indexCell;
        int indexList = 0;
        for (int currentNum : list) {
            indexRow = indexList / rows;
            indexCell = indexList % rows;
            array[indexRow][indexCell] = currentNum;
            indexList++;
        }
        return array;
    }
}