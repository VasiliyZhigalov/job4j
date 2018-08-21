package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * флаг для выхода из цикла
     */
    private boolean working = true;
    /**
     * Запорос пользователя
     */

    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
      Tracker tracker = new Tracker();
      MenuTracker menu = new MenuTracker(this.input, tracker);
      menu.fillActions(this);
      do {
          menu.show();
          menu.select(input.ask("Выберите пункт меню:", menu.ranges(this)));
      } while (this.working);
    }

    /**
     * выход из цикла.
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}