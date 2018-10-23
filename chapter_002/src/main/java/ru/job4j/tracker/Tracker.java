package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    private List<String> id = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item
     */
    public Item add(Item item) {
        item.setId(this.generateId(item.getCreated()));
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId(long created) {

        return created + "-" + Math.random();
    }

    /**
     * Заменить ячейку в массиве заявок
     *
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            items.set(index, item);
            items.get(index).setId(id);
            result = true;
        }
        return result;
    }

    /**
     * сравнение id
     *
     * @param id
     * @param item
     * @return
     */
    private boolean comparID(String id, Item item) {
        Predicate<String> predicate = idF -> item.getId().equals(idF);
        return predicate.test(id);
    }

    /**
     * Ищет заявку по id
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        int index = findIndexById(id);
        return index == -1 ? null : items.get(index);
    }

    /**
     * Ищет заявки с именем key
     *
     * @param key
     * @return
     */
    public List<Item> findByName(String key) {
        List<Item> itemByName = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                itemByName.add(item);
            }
        }
        return itemByName;
    }

    /**
     * Ищет индекс по id
     *
     * @param id
     * @return
     */
    private int findIndexById(String id) {
        int result = -1;
        int index = 0;
        for (Item item : items) {
            if (comparID(id, item)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * удаление заявки по ид
     *
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            items.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * возвращает копию массива this.items без null элементов;
     *
     * @return
     */
    public List<Item> findAll() {
        return this.items;
    }


}

