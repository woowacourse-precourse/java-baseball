package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private static Game game;
    private static User user;

    @BeforeEach
    private void createGame() {
        game = new Game();
        user = new User();
    }

    @Test
    void 결과_문자열_변환_유효성_검사() {
        List<Integer> result = Arrays.asList(0, 0);
        assertThat(game.getResultCvtToStr(result)).isEqualTo("낫싱");
    }

    @Test
    void 게임_재개_여부_유효성_검사() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.start();
        assertThat(game.toBeContinue()).isEqualTo(true);
    }

}
