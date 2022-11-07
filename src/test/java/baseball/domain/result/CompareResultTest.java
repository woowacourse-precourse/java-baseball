package baseball.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CompareResult 는")
class CompareResultTest {

    @Test
    @DisplayName("strike 개수를 증가시킬 수 있다.")
    void addStrike() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addStrike();

        // then
        assertThat(compareResult.toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("ball 개수를 증가시킬 수 있다.")
    void addBall() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addBall();

        // then
        assertThat(compareResult.toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("ball 과 strike가 없는 경우 `낫싱`을 반환한다.")
    void return_낫싱_whenNoBallAndStrike() {
        // given
        CompareResult compareResult = new CompareResult();

        // when, then
        assertThat(compareResult.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("3 strike인 경우 정답이다.")
    void isAnswerWhen3Strike() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addStrike();
        compareResult.addStrike();
        compareResult.addStrike();

        // when, then
        assertThat(compareResult.isAnswer()).isTrue();
        assertThat(compareResult.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("3 strike가 아닌 경우 정답이 아니다.")
    void ifNot3StrikeThenIsNotAnswer() {
        // given
        CompareResult compareResult = new CompareResult();

        // when
        compareResult.addStrike();
        compareResult.addStrike();

        // when, then
        assertThat(compareResult.isAnswer()).isFalse();
    }
}