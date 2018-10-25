package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

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
        Item replaceItem = this.findById(id);
        if (replaceItem != null) {
            int index = items.indexOf(replaceItem);
            items.set(index, item);
            items.get(index).setId(id);
            result = true;
        }
        return result;
    }

    /**
     * Ищет заявку по id
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findAny().orElse(null);
    }

    /**
     * Ищет заявки с именем key
     *
     * @param key
     * @return
     */
    public List<Item> findByName(String key) {
        List<Item> itemByName = items.stream().filter(item -> item.getName().equals(key)).collect(Collectors.toList());
        return itemByName;
    }

    /**
     * удаление заявки по ид
     *
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        Item delItem = findById(id);
        if (delItem != null) {
            items.remove(delItem);
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

