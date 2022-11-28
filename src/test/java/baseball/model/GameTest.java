package baseball.model;

import baseball.model.game.Game;
import baseball.model.game.GameResult;
import baseball.model.number.NumberCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private static final NumberCollection computerNumbers = new NumberCollection(List.of(1, 2, 3));
    private static final Game game = new Game(computerNumbers);

    @DisplayName("플레이어 숫자에 대한 게임 결과 객체를 반환한다")
    @ParameterizedTest
    @MethodSource("resultOfPlayerNumbersTestSource")
    void resultOfPlayerNumbersTest(List<Integer> numbers, GameResult expected) {
        NumberCollection playerNumbers = new NumberCollection(numbers);
        GameResult actual = game.getResultOf(playerNumbers);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> resultOfPlayerNumbersTestSource() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3), new GameResult(0, 3)
                ),
                Arguments.of(
                        List.of(3, 2, 1), new GameResult(2, 1)
                ),
                Arguments.of(
                        List.of(4, 5, 6), new GameResult(0, 0)
                )
        );
    }

}
