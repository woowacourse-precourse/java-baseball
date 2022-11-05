package baseball.computer;

import baseball.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void test_유저_입력_검증() {
        String input = "385";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = new User();
        Computer computer = new Computer();
        computer.start();
        Integer userInput = computer.getUserInput(user);

        Assertions.assertEquals(385, userInput);
    }

    @Test
    void test_유저_입력_숫자가_아닌_경우() {
        String input = "365abc";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = new User();
        Computer computer = new Computer();
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, () -> computer.getUserInput(user));
    }

    @Test
    void test_유저_입력_숫자_범위가_벗어난_경우() {
        String input = "10423";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = new User();
        Computer computer = new Computer();
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, () -> computer.getUserInput(user));
    }
}