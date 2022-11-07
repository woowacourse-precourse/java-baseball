package baseball.domain.Generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class GameGeneratorTest {

    private static final int LENGTH_OF_GAME = 3;

    @Test
    void createGame() {
        List<Integer> generatedGame = GameGenerator.createGame();
        assertAll(
                () -> assertThat(generatedGame.size()).isEqualTo(LENGTH_OF_GAME),
                () -> assertThat(generatedGame.stream()
                        .distinct()
                        .count())
                        .isEqualTo(LENGTH_OF_GAME)
        );
    }
}