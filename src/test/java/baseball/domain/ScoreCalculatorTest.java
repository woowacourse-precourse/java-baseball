package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ScoreCalculatorTest {
    @Nested
    @DisplayName("각 자리수마다 서로 다른 자리수가 있는 경우, ballCount는 1 증가하는지 테스트한다")
    class Ball {
        @ParameterizedTest
        @CsvSource(value = {"123, 123, 0", "123, 392, 2", "567, 345, 1"})
        void calculateBallCountTest(int number1, int number2, int expected) {
            BaseballNumber baseballNum1 = new BaseballNumber(number1);
            BaseballNumber baseballNum2 = new BaseballNumber(number2);
            assertThat(ScoreCalculator.calculateBallCount(baseballNum1, baseballNum2))
                    .isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("각 자리수마다 서로 같은 자리수가 있는 경우, strikeCount는 1 증가한다")
    class Strike {
        @ParameterizedTest
        @CsvSource(value = {"123, 123, 3", "123, 392, 0", "465, 345, 1"})
        void calculateStrikeCountTest(int number1, int number2, int expected) {
            BaseballNumber baseballNum1 = new BaseballNumber(number1);
            BaseballNumber baseballNum2 = new BaseballNumber(number2);
            assertThat(ScoreCalculator.calculateStrikeCount(baseballNum1, baseballNum2))
                    .isEqualTo(expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("Ball과 Strike가 둘 다 있는 경우를 테스트한다")
    class BallAndStrike {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void calculateBallAndStrikeTest(int number1, int number2, List<Integer> expected) {
            System.out.println(expected);
            BaseballNumber baseballNum1 = new BaseballNumber(number1);
            BaseballNumber baseballNum2 = new BaseballNumber(number2);
            assertThat(ScoreCalculator
                    .calculateUserFinalScore(baseballNum1, baseballNum2)
                    .getScore())
                    .isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(123, 136, Arrays.asList(1, 1)),
                    Arguments.of(123, 132, Arrays.asList(2, 1))
            );
        }
    }
}
