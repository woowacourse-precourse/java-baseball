package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {
    @Test
    @DisplayName("생성자를 통해 생성 시 스트라이크와 볼의 값이 초기화 되는지 확인한다.")
    void constructor() {
        int strikeValue = 0;
        int ballValue = 0;
        Result result = new Result();
        assertAll(
                () -> assertThat(result.getStrike()).as("초기 스트라이크 값이 0이다.").isEqualTo(strikeValue),
                () -> assertThat(result.getBall()).as("초기 볼 값이 0이다.").isEqualTo(ballValue)
        );
    }

    @ParameterizedTest(name = "스트라이크가 1씩 증가하는지 확인한다. 증가 횟수: {0}")
    @ValueSource(ints = {1, 2, 3})
    void increaseStrike(int increaseValue) {
        Result result = new Result();
        for (int i = 0; i < increaseValue; i++) {
            result.increaseStrike();
        }
        assertThat(result.getStrike()).as("스트라이크 증가 여부 확인")
                .isEqualTo(increaseValue);
    }

    @ParameterizedTest(name = "볼이 1씩 증가하는지 확인한다. 증가 횟수: {0}")
    @ValueSource(ints = {1, 2, 3})
    void increaseBall(int increaseValue) {
        Result result = new Result();
        for (int i = 0; i < increaseValue; i++) {
            result.increaseBall();
        }
        assertThat(result.getBall()).as("볼 증가 여부 확인")
                .isEqualTo(increaseValue);
    }

    @ParameterizedTest(name = "정답 결과가 정상적으로 계산되는지 확인한다. 정답: {0}, 입력값: {1}, {2}볼 {3}스트라이크(정답 여부: {4})")
    @CsvSource(value = {
            "123,123,0,3,true",
            "123,124,0,2,false",
            "123,132,2,1,false",
            "123,134,1,1,false",
            "123,145,0,1,false",
            "123,456,0,0,false",

    })
    void getResult(String computerString, String playerString, int ballValue, int strikeValue,
                   boolean expectedIsCorrectBalls) {
        Balls computerBalls = Balls.from(computerString);
        Balls playerBalls = Balls.from(playerString);
        Result result = Result.getResult(computerBalls, playerBalls);
        assertAll(
                () -> assertThat(result.getBall()).as("볼 갯수가 일치하는지 확인")
                        .isEqualTo(ballValue),
                () -> assertThat(result.getStrike()).as("스트라이크 갯수가 일치하는지 확인")
                        .isEqualTo(strikeValue),
                () -> assertThat(result.isCorrect()).as("정답 여부 확인")
                        .isEqualTo(expectedIsCorrectBalls)
        );
    }
}
