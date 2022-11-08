package baseball.utils;

import baseball.model.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    @BeforeAll
    static void init() {
        Game game = new Game();
        UserInput userInput = new UserInput(game, 3);
    }

    @Test
    void 사용자_입력값이_숫자인지_여부_판단() {
        String userInput = "abc";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.setUserInput();
        });

        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }

    @Test
    void 사용자_입력값이_3자리인지_여부_판단() {
        String userInput = "012";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.setUserInput();
        });

        assertEquals("3자리 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    void 사용자_입력값에_중복이_있는지_여부_판단() {
        String userInput = "122";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.setUserInput();
        });

        assertEquals("중복되지 않는 3자리 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    void 게임_재시작_여부_입력값이_1_또는_2인지_판단() {
        String userInput = "3";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.getNewGameStatusInput();
        });

        assertEquals("1 또는 2중에서 입력해주세요.", exception.getMessage());
    }
}