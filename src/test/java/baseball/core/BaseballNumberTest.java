package baseball.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BaseballNumberTest {

    @DisplayName("플레이어의 입력 숫자에서 볼이 몇 개인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"234:2", "356:1", "341:2", "456:0", "123:0"}, delimiter = ':')
    void countTheNumberOfBall(String inputNumber, int expectedNumberOfBall) {
        BaseballNumber baseballNumber = new BaseballNumber("123");
        int numberOfBall = baseballNumber.countTheNumberOfBall(inputNumber);
        assertThat(numberOfBall).isEqualTo(expectedNumberOfBall);
    }

    @DisplayName("플레이어의 입력 숫자에서 스트라이크가 몇 개인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"423:2", "425:1", "321:1", "456:0", "123:3"}, delimiter = ':')
    void countTheNumberOfStrike(String inputNumber, int expectedNumberOfStrike) {
        BaseballNumber baseballNumber = new BaseballNumber("123");
        int numberOfStrike = baseballNumber.countTheNumberOfStrike(inputNumber);
        assertThat(numberOfStrike).isEqualTo(expectedNumberOfStrike);
    }
}