package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Вывести все заявки.
     */
    private static final String SHOW = "1";
    /**
     * Изменить заявку
     */
    private static final String EDIT = "2";
    /**
     * Удалить заявку
     */
    private static final String DELETE = "3";
    /**
     * Найти заявку по ид
     */
    private static final String FINDBYID = "4";

    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
               this.findByID();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }



    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с ID : " + item.getId() + "-----------");
    }

    /**
     * Метод выводить все текущие заявки на экран
     */
    private void showItems() {
        System.out.println("------------ Текущие заявки --------------");
       System.out.println(this.tracker.findAll().length);
       for (Item item : this.tracker.findAll()) {
            System.out.println("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время_создания: " + item.getCreated());
        }
    }

    /**
     * Метод изменяет заявку.
     */
    private void editItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите номер заявки для изаменения :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            this.tracker.replace(id, item);
            System.out.println("------------ Заявка с ID : " + id +  " изменена -----------");
        } else {
            System.out.println("------------ Заявка с ID : " + id +  " не найдена -----------");
        }

    }

    /**
     * Метод удаляет заявку
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки для удаления :");
        if (this.tracker.delete(id)) {
            this.tracker.delete(id);
            System.out.println("------------ Заявка с ID: " + id + " удалена -----------");
        } else {
            System.out.println("------------ Заявка с ID: " + id + " не найдена -----------");
        }
    }

    /**
     * Метод ищет заявку по ID
     */
    private void findByID() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("ID: " + id + " Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время_создания: " + item.getCreated());
    }
    /**
     * Метод ищет заявку по имени
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        System.out.println("------------ Найдены следующие заявки--------------");
        for (Item item:items) {
            System.out.println("ID: " + item.getId() + " Имя: " + item.getName() + " Описание: " + item.getDesc() + " Время_создания: " + item.getCreated());
        }
    }
    /**
     * Метод выводит меню в консоль.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Создать новую заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Изменить заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по номеру.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выход из программы.");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}