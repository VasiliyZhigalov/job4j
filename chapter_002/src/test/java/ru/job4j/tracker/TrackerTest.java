package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    // тест поиска по ид
    @Test
    public void whenIdTest2ThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item1);
        tracker.add(item2);
        //System.out.println( tracker.findById("test2").getName());
        assertThat("testDescription2", is(tracker.findById("test2").getName()));
    }
    //тест поиска по имени
    @Test
    public void whenNameTestDescription1ThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "name1", 123L);
        Item item2 = new Item("test2", "name2", 1234L);
        Item item3 = new Item("test3", "name1", 1234L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat("test3", is(tracker.findByName("name1")[1].getId()));
    }
    //тест изменени заявки
    @Test
    public void whenThenFindNameTestDescription2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item1);
        tracker.replace("test1", item2);
        assertThat("testDescription2", is(tracker.findById("test2").getName()));
    }
    // удаления и поиска всех существующих заявок
    @Test
    public void whenDeleteThen() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "name1", 123L);
        Item item2 = new Item("test2", "name2", 1234L);
        Item item3 = new Item("test3", "name3", 1234L);
        Item item4 = new Item("test4", "name4", 1234L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete("test2");
        assertThat("test3", is(tracker.findAll()[1].getId()));
    }

}
