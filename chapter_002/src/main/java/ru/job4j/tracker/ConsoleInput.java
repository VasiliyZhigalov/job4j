package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Вывод вопроса и получеине ответа
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        new ValidateInput(this).notInTheRange(key, range);
        return key;
    }

}
