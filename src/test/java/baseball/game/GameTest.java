package baseball.game;

import baseball.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game = new Game();

    @Test
    void 두_숫자_비교1() {
        assertThat(game.compareTwoNumberStrings("123", "125"))
                .containsEntry("strike", 2);
    }

    @Test
    void 두_숫자_비교2() {
        assertThat(game.compareTwoNumberStrings("123", "312"))
                .containsEntry("ball", 3);
    }

    @Test
    void 두_숫자_비교3() {
        assertThat(game.compareTwoNumberStrings("123", "456"))
                .hasSize(0);
    }

    @Test
    void 두_숫자_비교4() {
        assertThat(game.compareTwoNumberStrings("123", "135"))
                .containsEntry("strike", 1)
                .containsEntry("ball", 1);
    }
}
