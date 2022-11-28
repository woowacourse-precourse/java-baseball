package baseball.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberTest {
    @DisplayName("index와 number이 모두 같다면 같은 객체이다")
    @ParameterizedTest
    @MethodSource("equalsTestSource")
    void equalsTest(GameNumber gameNumber1, GameNumber gameNumber2, boolean expected) {
        assertThat(gameNumber1.equals(gameNumber2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> equalsTestSource() {
        return Stream.of(
                Arguments.of(new GameNumber(1, 1), new GameNumber(1, 1), true),
                Arguments.of(new GameNumber(1, 1), new GameNumber(1, 2), false),
                Arguments.of(new GameNumber(1, 1), new GameNumber(2, 1), false)
        );
    }
}
