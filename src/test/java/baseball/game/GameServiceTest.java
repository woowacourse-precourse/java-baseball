package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceTest {

    @Test
    @DisplayName("게임 시작 시 올바르지 않은 값을 입력했을 때 예외를 던지는지 테스트")
    void startTest() {
        // given
        String userInputNumber = "335";
        InputStream input = new ByteArrayInputStream(userInputNumber.getBytes());
        System.setIn(input);

        // when, then
        GameService game = new GameService();
        assertThrows(IllegalArgumentException.class, game::start);
    }

    @Test
    @DisplayName("사용자가 게임을 계속한다고 입력했을 때 true를 리턴하는지 테스트")
    void restartTest() {
        String gameOverNumber = "1";
        InputStream input = new ByteArrayInputStream(gameOverNumber.getBytes());
        System.setIn(input);

        GameService game = new GameService();
        assertTrue(game.restart());
    }
}
