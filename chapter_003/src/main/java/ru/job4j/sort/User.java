package ru.job4j.sort;

import java.util.Comparator;

public class User implements Comparable<User> {
    public String name;
    public Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
