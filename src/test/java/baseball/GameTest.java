package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    void restart_종료를_선택할때() {
        String input = "2";
        Game game = new Game();
        assertThat(game.restart(input)).isFalse();
    }

    @Test
    void restart_재시작을_선택할때() {
        String input = "1";
        Game game = new Game();
        assertThat(game.restart(input)).isTrue();
    }
}
