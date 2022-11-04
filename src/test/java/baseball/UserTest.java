package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {
    private static User user;

    @BeforeAll
    static void initAll() {
        user = new User();
    }


    @Test
    void numberToListCheck() {
        List<Integer> userNumberList = user.numberToList(536);
        List<Integer> testList = Arrays.asList(5, 3, 6);
        assertIterableEquals(testList, userNumberList);
    }

    @Test
    void numberCheckTest() {
        boolean result = user.checkNumber(902);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void checkTypeTest() {
        boolean result = user.checkType("sd");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void inputNumberTest1() {
        String input = "23s";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = user.inputNumber();
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void inputNumberTest2() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = user.inputNumber();
        assertThat(result).isEqualTo(123);
    }


}