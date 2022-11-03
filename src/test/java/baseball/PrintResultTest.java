package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintResultTest {
    @ParameterizedTest
    @CsvSource("0, 0")
    void NOTHING_결과_출력(int strikeCount, int ballCount) {
        Game game = new Game();
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(Game.NOTHING);
    }
}
