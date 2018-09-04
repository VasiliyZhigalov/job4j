package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private String[]  id = new String[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item
     */
    public Item add(Item item) {
        item.setId(this.generateId(item.getCreated()));
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId(long created) {

        return created + "-" + Math.random();
    }
    /**
     * Заменить ячейку в массиве заявок
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            result = true;
        }
        return result;
    }
    /**
     * Ищет заявку по id
     * @param id
     * @return
     */
    public Item findById(String id) {
        int index = findIndexById(id);
        return index == -1 ? null : items[index];
    }

    /**
     * Ищет заявки с именем key
     * @param key
     * @return
     */
   public Item[] findByName(String key) {
        Item[] itemByName = new Item[items.length];
        int counter = 0;
        for (int i = 0; i < this.position; i++) {
                if (key.equals(items[i].getName())) {
                   itemByName[counter] = items[i];
                    counter++;
                }
        }
        return Arrays.copyOf(itemByName, counter);
    }

    /**
     * Ищет индекс по id
     * @param id
     * @return
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int index = 0; index < this.position; index++) {
            if (id.equals(items[index].getId())) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * удаление заявки по ид
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, items.length - index - 1);
            this.position--;
            result = true;
        }
        return result;
    }
    /**
     * возвращает копию массива this.items без null элементов;
     * @return
     */
    public Item[] findAll() {

        return Arrays.copyOf(this.items, this.position);
    }



}

