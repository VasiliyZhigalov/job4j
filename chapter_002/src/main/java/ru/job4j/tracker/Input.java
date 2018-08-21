package ru.job4j.tracker;

public interface Input {
    /**
     *
     * @param question
     * @return
     */
     String ask(String question);
     int ask(String question, int[] range);
}
