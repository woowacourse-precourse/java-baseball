package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private final Game game = new Game();

    @Test
    void getterTest() {
        Assertions.assertAll(
                () -> assertThat(game.getStrike()).isEqualTo(0),
                () -> assertThat(game.getBall()).isEqualTo(0)
        );

    }
}
