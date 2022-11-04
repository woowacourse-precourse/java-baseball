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

    @ParameterizedTest
    @CsvSource("3, 0")
    void _3_STRIKE_결과_출력(int strikeCount, int ballCount) {
        Game game = new Game();
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
                strikeCount + Game.STRIKE + Game.NEW_LINE + Game.GAME_OVER);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "1, 1",
            "1, 3",
    })
    void BALL_STRIKE_결과_출력(int strikeCount, int ballCount) {
        Game game = new Game();
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
                ballCount + Game.BALL + Game.BLANK + strikeCount + Game.STRIKE);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "0, 2",
            "0, 3",
    })
    void BALL만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        Game game = new Game();
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
                ballCount + Game.BALL);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
    })
    void STRIKE만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        Game game = new Game();
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
                strikeCount + Game.STRIKE);
    }
}
