package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    void inputNumberTest1() {
        String input = "23s";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> user.inputGameNumber());
    }

    @Test
    void inputNumberTest2() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.inputGameNumber();
        assertThat(user.userNumber).isEqualTo(123);
    }
}