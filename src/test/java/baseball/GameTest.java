package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Game_랜덤으로_숫자생성() {
        Game game1 = new Game();
        Game game2 = new Game();

        assertThat(game1.computer).isNotEqualTo(game2.computer);
    }

}