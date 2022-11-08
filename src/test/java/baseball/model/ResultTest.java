package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("생성자를 통해 생성 시 속성값이 정상적으로 초기화되는지 확인 한다.")
    void 생성자_테스트() {
        // given
        int expectedStrikeInitValue = 0;
        int expectedBallInitValue = 0;

        // when
        Result result = new Result();

        //then
        assertThat(result.getStrike()).as("초기 스트라이크 값이 0 인지 확인.")
                .isEqualTo(expectedStrikeInitValue);

        assertThat(result.getBall()).as("초기 볼 값이 0 인지 확인.")
                .isEqualTo(expectedBallInitValue);
    }

    @ParameterizedTest(name = "스트라이크 1씩 증가하는지 확인한다. 증가 횟수: {0}")
    @ValueSource(ints = {1, 2, 3})
    void 스트라이크_증가_테스트(int increaseCount) {
        // given
        Result result = new Result();

        // when
        for (int i = 0; i < increaseCount; i++) {
            result.increaseStrike();
        }

        //then
        assertThat(result.getStrike()).as("스트라이크 증가 여부 확인")
                .isEqualTo(increaseCount);
    }

    @ParameterizedTest(name = "볼이 1씩 증가하는지 확인한다. 증가 횟수: {0}")
    @ValueSource(ints = {1, 2, 3})
    void 볼_증가_테스트(int increaseCount) {
        // given
        Result result = new Result();

        // when
        for (int i = 0; i < increaseCount; i++) {
            result.increaseBall();
        }

        //then
        assertThat(result.getBall()).as("볼 증가 여부 확인")
                .isEqualTo(increaseCount);
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
    void getResult(String targetAnswerString, String inputAnswerString, int expectedBallCount, int expectedStrikeCount, boolean expectedIsCorrectAnswer) {
        // given
        Answer targetAnswer = Answer.fromString(targetAnswerString);
        Answer inputAnswer = Answer.fromString(inputAnswerString);

        // when
        Result result = Result.getResult(targetAnswer, inputAnswer);

        //then
        assertThat(result.getBall()).as("볼 갯수가 일치하는지 확인")
                .isEqualTo(expectedBallCount);

        assertThat(result.getStrike()).as("스트라이크 갯수가 일치하는지 확인")
                .isEqualTo(expectedStrikeCount);

        assertThat(result.isCorrectAnswer()).as("정답 여부 확인")
                .isEqualTo(expectedIsCorrectAnswer);
    }
}