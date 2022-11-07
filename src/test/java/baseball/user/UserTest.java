package baseball.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class UserTest {


    @Test
    public void test_유저_입력_개행_반복() {
        String input = "Hello World!\nHello World2!\n";
        String expected1 = "Hello World!";
        String expected2 = "Hello World2!";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = new User();

        String result = user.getUserInput();
        Assertions.assertEquals(expected1, result);

        result = user.getUserInput();
        Assertions.assertEquals(expected2, result);
    }
}
