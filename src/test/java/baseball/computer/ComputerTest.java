package baseball.computer;

import baseball.user.User;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void 유저_정상_입력_검증_테스트() {
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
    void 유저_문자_입력_예외_테스트() {
        String input = "365abc";
        User user = getUser();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Computer computer = new Computer();
        computer.setUser(user);
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, computer::getUserInput);
    }

    @Test
    void 유저_범위_초과_입력_예외_테스트() {
        String input = "10423";
        User user = getUser();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Computer computer = new Computer();
        computer.setUser(user);
        computer.start();

        Assertions.assertThrows(IllegalArgumentException.class, computer::getUserInput);
    }


    @Test
    void 유저_입력결과_추측_테스트() {
        User user = getUser();

        Computer computer = new Computer();
        computer.setUser(user);

        List<Integer> answer = new ArrayList<>();
        answer.add(4);
        answer.add(5);
        answer.add(6);
        computer.setAnswers(answer);

        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> output = computer.guessNumber(456);

        Assertions.assertEquals(3, output.get(0));
        Assertions.assertEquals(0, output.get(1));
    }
}