package baseball.model;


import baseball.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberTest {

    @DisplayName("다른 index, 같은 number을 가졌다면 참을 반환한다")
    @ParameterizedTest
    @MethodSource("hasOnlyDifferentIndexTestSource")
    void hasOnlyDifferentIndexTest(GameNumber gameNumber1, GameNumber gameNumber2, boolean expected) {
        boolean actual = gameNumber1.hasOnlyDifferentIndexWith(gameNumber2);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("index와 number이 모두 같다면 같은 객체이다")
    @ParameterizedTest
    @MethodSource("equalsTestSource")
    void equalsTest(GameNumber gameNumber1, GameNumber gameNumber2, boolean expected) {
        assertThat(gameNumber1.equals(gameNumber2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> hasOnlyDifferentIndexTestSource() {
        return Stream.of(
                Arguments.of(new GameNumber(0, 1), new GameNumber(1, 1), true),
                Arguments.of(new GameNumber(1, 1), new GameNumber(1, 1), false),
                Arguments.of(new GameNumber(0, 1), new GameNumber(1, 0), false)
        );
    }

    private static Stream<Arguments> equalsTestSource() {
        return Stream.of(
                Arguments.of(new GameNumber(1, 1), new GameNumber(1, 1), true),
                Arguments.of(new GameNumber(1, 1), new GameNumber(1, 2), false),
                Arguments.of(new GameNumber(1, 1), new GameNumber(2, 1), false)
        );
    }
}
