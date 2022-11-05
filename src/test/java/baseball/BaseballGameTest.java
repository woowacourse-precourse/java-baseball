package baseball;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    private final BaseballGame baseballGame = new BaseballGame();

    @Test
    void isEndGame_반환값이_true() {
        String input = "1";
        boolean result;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        result = baseballGame.isEndGame();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isEndGame_반환값이_false() {
        String input = "2";
        boolean result;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        result = baseballGame.isEndGame();
        assertThat(result).isEqualTo(false);
    }
}