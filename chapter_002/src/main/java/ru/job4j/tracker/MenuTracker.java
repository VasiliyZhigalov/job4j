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
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram(ui));
    }
    public int[] ranges(StartUI ui) {
        int[] ranges = new int[this.getActionsLentgh()];
        ranges[0] = new AddItem().key();
        ranges[1] = new ShowItems().key();
        ranges[2] = new MenuTracker.EditItem().key();
        ranges[3] = new MenuTracker.DeleteItem().key();
        ranges[4] = new FindItemById().key();
        ranges[5] = new FindItemsByName().key();
        ranges[6] = new ExitProgram(ui).key();
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
    public class AddItem implements UserAction {

        @Override
        public int key() {
            return ADD;
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

        @Override
        public String info() {
            return "0. Создать новую заявку.";
        }
    }
    public class ShowItems implements UserAction {

        @Override
        public int key() {
            return SHOW;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Текущие заявки --------------");
            System.out.println(tracker.findAll().length);
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }

        }

        @Override
        public String info() {
            return "1. Показать все заявки.";
        }
    }
    public static class EditItem implements UserAction {
        @Override
        public int key() {
            return EDIT;
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
        @Override
        public String info() {
            return "2. Изменить заявку.";
        }
    }
    public static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE;
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
        @Override
        public String info() {
            return "3. Удалить заявку.";
        }
    }
    public class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return FINDBYNAME;
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
    public class ExitProgram implements UserAction {
        private final StartUI ui;

        public ExitProgram(StartUI ui) {
            this.ui = ui;
        }

        @Override
        public int key() {
            return EXIT;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
                this.ui.stop();

        }
        @Override
        public String info() {
            return "6. Выход из программы.";
        }
    }
}
class FindItemById implements UserAction {
    @Override
    public int key() {
        return MenuTracker.FINDBYID;
    }
    @Override
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
    @Override
    public String info() {
        return "4. Найти заявку по номеру.";
    }
}

