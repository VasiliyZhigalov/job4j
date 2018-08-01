package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Vasiliy Zhigalov (mailto:vasiliyzhigalov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Vasiliy Zhigalov";
        String expect = "Echo, echo, echo : Vasiliy Zhigalov";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));

    }

}