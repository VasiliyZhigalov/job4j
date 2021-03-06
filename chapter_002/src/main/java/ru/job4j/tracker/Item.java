package ru.job4j.tracker;

import java.util.Arrays;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(long created, String name, String desc) {
        this.desc = desc;
        this.name = name;
        this.created = created;
    }
    public Item(String name, String desc) {
        this.desc = desc;
        this.name = name;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreated() {
        return created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " Имя: " + this.getName() + " Описание: " + this.getDesc() + " Время_создания: " + this.getCreated();
    }
}
