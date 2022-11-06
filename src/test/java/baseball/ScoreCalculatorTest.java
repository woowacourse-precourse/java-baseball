package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.ScoreCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {
    @Nested
    @DisplayName("각 자리수마다 서로 다른 자리수가 있는 경우, ballCount는 1 증가한다")
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
}
