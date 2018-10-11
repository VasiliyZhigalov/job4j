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
}

