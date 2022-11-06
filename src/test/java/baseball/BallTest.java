package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    Ball ball = new Ball();

    @DisplayName("볼 판독")
    @ParameterizedTest
    @MethodSource("generateData")
    void checkNumberOfStrikes(String inputNumber, String computerNumber, int index) {
        int ballCount = ball.compareCharacterDifferentLocationMatch(inputNumber, computerNumber);
        int[] result = {0, 0, 1, 1, 3};
        
        assertThat(ballCount).isEqualTo(result[index]);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("123", "123", 0),
                Arguments.of("123", "124", 1),
                Arguments.of("123", "134", 2),
                Arguments.of("123", "273", 3),
                Arguments.of("123", "312", 4)
        );
    }
}