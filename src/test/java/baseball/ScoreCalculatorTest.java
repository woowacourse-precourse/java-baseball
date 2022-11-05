package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {
    @DisplayName("각 자리수마다 서로 다른 자리수가 있는 경우, ballCount는 1 증가한다")
    @ParameterizedTest
    @CsvSource(value = {"123, 123, 0", "123, 392, 2", "567, 345, 1"})
    void calculateBallCountTest(int number1, int number2, int expected) {
        BaseballNumber baseballNum1 = new BaseballNumber(number1);
        BaseballNumber baseballNum2 = new BaseballNumber(number2);
        assertThat(ScoreCalculator.calculateBallCount(baseballNum1, baseballNum2))
                .isEqualTo(expected);
    }
}
