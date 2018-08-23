package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    public List<UserAction> actions = new ArrayList<UserAction>();
////////////////////////////////////////////////////////////////////////////////
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
    ///////////////////////////////////////////////////////
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker() {
    }
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Создать новую заявку."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new MenuTracker.EditItem(2, "Изменить заявку."));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по номеру."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(ui, 6, "Выход из программы."));
    }

    /**
     * Метод возращает диапозон меню.
     * @return
     */
    public int[] getRanges() {
        int[] ranges = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            ranges[i] = this.actions.get(i).key();
        }
        return  ranges;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
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
                System.out.println("------------ Заявка с ID : " + id +  " изменена -----------");
            } else {
                System.out.println("------------ Заявка с ID : " + id +  " не найдена -----------");
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
            for (Item item:items) {
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
        private final StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
                this.ui.stop();

        }
    }
}
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

