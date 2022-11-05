package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void checkRestartTest() {
        Game game = new Game();
        boolean result = true;
        String playerRestart = "1";
        assertThat(game.checkRestart(playerRestart)).isEqualTo(result);
        result = false;
        playerRestart = "2";
        assertThat(game.checkRestart(playerRestart)).isEqualTo(result);
    }
}
