package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenUserListThenUserMap() {
        List<User> userList = Arrays.asList(
                new User(1, "Vasiliy", "Izhevsk"),
                new User(2, "Ivan", "Ivanovo")
        );
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(userList);

        assertThat(result.get(2).getName(), is("Ivan"));
    }
}