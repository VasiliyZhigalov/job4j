package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    public List<UserAction> actions = new ArrayList<UserAction>();
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    /**
     * Вывести все заявки.
     */
    private static final int SHOW = 1;
    /**
     * Изменить заявку
     */
    private static final int EDIT = 2;
    /**
     * Удалить заявку
     */
    private static final int DELETE = 3;
    /**
     * Найти заявку по ид
     */
    public static final int FINDBYID = 4;
    /**
     * Найти заявки по имени
     */
    private static final int FINDBYNAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;

    /**
     * Конструктор.
     *
     * @param input
     * @param tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(ADD, "Создать новую заявку."));
        this.actions.add(new ShowItems(SHOW, "Показать все заявки."));
        this.actions.add(new MenuTracker.EditItem(EDIT, "Изменить заявку."));
        this.actions.add(new MenuTracker.DeleteItem(DELETE, "Удалить заявку."));
        this.actions.add(new FindItemById(FINDBYID, "Найти заявку по номеру."));
        this.actions.add(new FindItemsByName(FINDBYNAME, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(EXIT, "Выход из программы."));
    }

    /**
     * Метод возращает диапозон меню.
     *
     * @return
     */
    public int[] getRanges() {
        int[] ranges = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            ranges[i] = this.actions.get(i).key();
        }
        return ranges;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Добавление заявки
     */
    public class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с ID : " + item.getId() + "-----------");
        }

    }

    /**
     * Показать заявки
     */
    public class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Текущие заявки --------------");
            System.out.println(tracker.findAll().length);
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }

        }
    }

    public static class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки --------------");
            String id = input.ask("Введите номер заявки для изаменения :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка с ID : " + id + " изменена -----------");
            } else {
                System.out.println("------------ Заявка с ID : " + id + " не найдена -----------");
            }
        }
    }

    /**
     * удаление заявки
     */
    public static class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки для удаления :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка с ID: " + id + " удалена -----------");
            } else {
                System.out.println("------------ Заявка с ID: " + id + " не найдена -----------");
            }
        }
    }

    public class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] items = tracker.findByName(name);
            System.out.println("------------ Найдены следующие заявки--------------");
            boolean res = false;
            for (Item item : items) {
                res = true;
                System.out.println(item.toString());
            }
            if (!res) {
                System.out.println(" Заявок не найдено");
            }
        }

        @Override
        public String info() {
            return "5. Найти заявку по имени.";
        }
    }

    /**
     * Класс для выхода из программы
     */
    public class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Программа завершена.");
        }
    }
}

/**
 * Класс для поиска по ID
 */
class FindItemById extends BaseAction {
    public FindItemById(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("------------ Заявка с ID: " + id + " не найдена -----------");
        }
    }
}

