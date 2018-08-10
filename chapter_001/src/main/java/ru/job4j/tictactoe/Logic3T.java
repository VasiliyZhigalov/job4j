package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
    /**
     *  проверяет заполнена ли строка true/
     * @param hasMark массив с отметаки заполнения.
     * @param rowBegin начельная строка
     * @param colBegin начальный столбец
     * @param rowStep шаг по строке
     * @param colStep шаг по столбцу
     * @return true если строка заполнена, иначе false/
     */
    private boolean isWin(boolean[][] hasMark, int rowBegin, int colBegin, int rowStep, int colStep) {
        int rS = rowBegin;
        int cS = colBegin;
        boolean result = true;
        if (!hasMark[rowBegin][colBegin]) {
            result = false;
        } else {
            for (int i = 0; i < hasMark.length; i++) {
                if (hasMark[rowBegin][colBegin] != hasMark [rS][cS]) {
                    result = false;
                    break;
                }
                rS += rowStep;
                cS += colStep;
            }
        }
        return result;
    }
    /**
     * победа крестиков
     * @return true если победили крестики
     */
    public boolean isWinnerX() {
        int rows = this.table.length;
        boolean[][] hasX = new boolean[rows][rows];
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < rows; in++) {
                hasX[in][out] = this.table[in][out].hasMarkX();
            }
        }
        boolean result = false;
        for (int i = 0; i < rows; i++) {
            result = result || isWin(hasX, i, 0, 0, 1) || isWin(hasX, 0, i, 1, 0);
        }
        result = result || isWin(hasX, 0, 0, 1, 1) || isWin(hasX, 0, rows - 1, 1, -1);
        return result;
    }
    /**
     *  Победа ноликов.
     * @return true если победили нолики.
     */
    public boolean isWinnerO() {
        int rows = this.table.length;
        boolean[][] hasX = new boolean[rows][rows];
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < rows; in++) {
                hasX[in][out] = this.table[in][out].hasMarkO();
            }
        }
        boolean result = false;
        for (int i = 0; i < rows; i++) {
            result = result || isWin(hasX, i, 0, 0, 1) || isWin(hasX, 0, i, 1, 0);
        }
        result = result || isWin(hasX, 0, 0, 1, 1) || isWin(hasX, 0, rows - 1, 1, -1);
        return result;
    }

    /**
     *  Проверяет заполнено ли поле.
     * @return true если заполнено.
     */
    public boolean hasGap() {
        int rows = this.table.length;
        boolean hasGap = false;

        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < rows; in++) {
                if (!this.table[out][in].hasMarkX() && !this.table[out][in].hasMarkO()) {
                    hasGap = true;
                    break;
                }
            }
        }
        return hasGap;
    }
}
