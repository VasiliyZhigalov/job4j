package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private  final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private StringBuilder outStr = new StringBuilder();
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        System.out.println(tracker.findById(item.getId()).getName());
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeleteValue() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(1).getName(), is("test name3"));
    }
    @Test
    public void whenFindByIdThenTrackerHasItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));

        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    @Test
    public void whenFindByNameThenTrackerHasItemWithSameDescription() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).get(0).getDesc(), is("test description"));
    }
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After

    public void backOutput() {
        System.setOut(new PrintStream(stdout));
    }
    /**
     * вывод на экран показать все заявки
     */
    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name 1", "test description"));
        Item item2 = tracker.add(new Item("test name 2", "test description"));
        Input input = new StubInput(new String[]{"1", "6"});
        menuToString();
        String ln = System.lineSeparator();
        outStr.append("------------ Текущие заявки --------------");
        outStr.append(ln);
        outStr.append(tracker.findAll().size());
        outStr.append(ln);
        for (Item item: tracker.findAll()) {
            outStr.append(item.toString());
            outStr.append(ln);
        }
        menuToString();
        outStr.append("Программа завершена.");
        outStr.append(ln);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(outStr.toString()));
    }

    /**
     * вывод на экран поиска по имени
     */
    @Test
    public void whenShowFoundItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name 1", "test description"));
        Item item2 = tracker.add(new Item("test name 2", "test description"));
        Input input = new StubInput(new String[]{"5", "test name 2", "6"});
        String ln = System.lineSeparator();
        menuToString();
        outStr.append("------------ Поиск заявки по имени --------------");
        outStr.append(ln);
        outStr.append("------------ Найдены следующие заявки--------------");
        outStr.append(ln);
        for (Item item: tracker.findByName("test name 2")) {
            outStr.append(item.toString());
            outStr.append(ln);
        }
        menuToString();
        outStr.append("Программа завершена.");
        outStr.append(ln);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(outStr.toString()));
    }


    private void menuToString() {
        String ln = System.lineSeparator();
        outStr  .append("0. Создать новую заявку.")
                .append(ln)
                .append("1. Показать все заявки.")
                .append(ln)
                .append("2. Изменить заявку.")
                .append(ln)
                .append("3. Удалить заявку.")
                .append(ln)
                .append("4. Найти заявку по номеру.")
                .append(ln)
                .append("5. Найти заявку по имени.")
                .append(ln)
                .append("6. Выход из программы.")
                .append(ln);

    }
}
