package ru.job4j.sort;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class  SortUser {
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
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        Integer u1NameLength = u1.name.length();
                        Integer u2NameLength = u2.name.length();
                        return u1NameLength.compareTo(u2NameLength);
                    }
                });
        return users;
    }
    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        int result;
                        result = u1.name.compareTo(u2.name);
                        if (result == 0) {
                            result = u1.age.compareTo(u2.age);
                        }
                        return result;
                    }
                });
        return users;
    }

}
