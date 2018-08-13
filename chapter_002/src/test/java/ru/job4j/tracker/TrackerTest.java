package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    // тест поиска по ид
    @Test
    public void whenIdTest2ThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(123L, "test1", "testDescription1");
        Item item2 = new Item(1234L, "test2", "testDescription2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat("testDescription2", is(tracker.findByName("test2")[0].getDesc()));
    }
    //тест поиска по имени
    @Test
    public void whenNameTestDescription1ThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(123L, "test3", "name1");
        Item item2 = new Item(1234L, "test2", "name2");
        Item item3 = new Item(1234L, "test3", "name3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
       assertThat("name3", is(tracker.findByName("test3")[1].getDesc()));
    }
    //тест изменени заявки
    @Test
    public void whenThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(123L, "test1", "testDescription1");
        Item item2 = new Item(1234L, "test2", "testDescription2");
        tracker.add(item1);
        tracker.replace(item1.getId(), item2);
        assertThat("testDescription2", is(tracker.findByName("test2")[0].getDesc()));
    }
    // удаления и поиска всех существующих заявок
    @Test
    public void whenDeleteThen() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(123L, "test1", "name1");
        Item item2 = new Item(1234L, "test2", "name2");
        Item item3 = new Item(1234L, "test3", "name3");
        Item item4 = new Item(1234L, "test4", "name4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item2.getId());
        assertThat("test4", is(tracker.findAll()[2].getName()));
    }

}
