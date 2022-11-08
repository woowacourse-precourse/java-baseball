package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class GameTest {
    Game game = new Game();

    @Test
    void 스트라이크_3() {
        game.computerNumber = List.of(1, 2, 3);
        game.userNumber = List.of(1, 2, 3);

        assertThat(game.strike()).isEqualTo(3);
    }

    @Test
    void 볼_스트라이크() {
        game.computerNumber = List.of(1, 2, 3);
        game.userNumber = List.of(2, 6, 3);

        assertThat(game.ball()).isEqualTo(1);
        assertThat(game.strike()).isEqualTo(1);
    }

    @Test
    void 낫싱() {
        game.computerNumber = List.of(1, 2, 3);
        game.userNumber = List.of(4, 5, 6);

        assertThat(game.nothing()).isTrue();
    }
}
