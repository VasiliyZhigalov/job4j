package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет","Привет","Привет", "Мир", "Привет", "Супер", "Привет"};
        ArrayDuplicate arDuplicate = new ArrayDuplicate();
        String[] result = arDuplicate.remove(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
    @Test
    public void whenRemove() {
        String[] input = {"Привет", "Привет", "Привет", "Привет","Привет", "Привет"};
        ArrayDuplicate arDuplicate = new ArrayDuplicate();
        String[] result = arDuplicate.remove(input);
        String[] expect = {"Привет"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

}