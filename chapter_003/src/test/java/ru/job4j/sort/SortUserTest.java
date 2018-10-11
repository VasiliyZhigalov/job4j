package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortedAgeThenNameSergey() {
        SortUser sortUser = new SortUser();
        List<User> userList = Arrays.asList(new User("Ivan", 50), new User("Adam", 66), new User("Sergey", 12));
        Set<User> result = sortUser.sort(userList);
        assertThat(new ArrayList<>(result).get(0).name, is("Sergey"));
    }

    @Test
    public void whenSortNameLengthThenIvan() {
        SortUser sortUser = new SortUser();
        List<User> userList = Arrays.asList(new User("Mikhail", 50), new User("Ivan", 66), new User("Sergey", 12));
        List<User> result = sortUser.sortNameLength(userList);
        assertThat(result.get(0).name, is("Ivan"));
    }

    @Test
    public void whenSortByAllFieldsThenAdam34() {
        SortUser sortUser = new SortUser();
        List<User> userList = Arrays.asList(new User("Mikhail", 50), new User("Ivan", 30), new User("Adam", 66), new User("Adam", 34), new User("Sergey", 12));
        List<User> result = sortUser.sortByAllFields(userList);
        assertThat(result.get(0).name + "-" + result.get(0).age, is("Adam-34"));
    }
}

