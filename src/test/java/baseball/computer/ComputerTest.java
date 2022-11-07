package baseball.computer;

import baseball.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    User getUser() {
        User user = new User();
        try {
            while (user.getUserInput() != null);
        } catch (NoSuchElementException | IllegalArgumentException ignored) {

        }
        return user;
    }

    @Test
    void test_유저_입력_검증() {
        String input = "385";
        User user = getUser();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Computer computer = new Computer();
        computer.setUser(user);
        computer.start();
        Integer userInput = computer.getUserInput();

        Assertions.assertEquals(385, userInput);
    }

    @Test
    void test_유저_입력_숫자가_아닌_경우() {
        String input = "365abc";
        User user = getUser();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Computer computer = new Computer();
        computer.setUser(user);
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, () -> computer.getUserInput());
    }

    @Test
    void test_유저_입력_숫자_범위가_벗어난_경우() {
        String input = "10423";
        User user = getUser();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Computer computer = new Computer();
        computer.setUser(user);
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, () -> computer.getUserInput());
    }

}