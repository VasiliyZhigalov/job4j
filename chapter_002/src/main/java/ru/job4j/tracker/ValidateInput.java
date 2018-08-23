package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }
    @Override
    public String ask(String questoin) {
        return this.input.ask(questoin);
    }
    /**
     * Проверяет валидность полученных от пользователя данных.
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста, выберите пункт меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите допустимые данные");
            }
        } while (invalid);
        return value;
    }

    /**
     * Проверяет имеется ли ключ в диапозоне
     * @param key ключ
     * @param range диапозон ключей
     */
    public void notInTheRange(int key, int[] range) {
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }

    }
}
