package ru.job4j.sort;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Sort by name length
     *
     * @return
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(
                (u1, u2) -> {
                    Integer u1NameLength = u1.getName().length();
                    Integer u2NameLength = u2.getName().length();
                    return u1NameLength.compareTo(u2NameLength);
                });
        return users;
    }

    /**
     * sorted by name length than by age
     * @param users
     * @return
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                (u1, u2) -> {
                    int result;
                    result = u1.getName().compareTo(u2.getName());
                    if (result == 0) {
                        result = u1.getAge().compareTo(u2.getAge());
                    }
                    return result;
                }
        );
        return users;
    }

}
