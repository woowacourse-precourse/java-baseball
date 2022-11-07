package baseball.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest extends NsTest {
    Result result = Result.getInstance();

    @Test
    @DisplayName("스코어를 보고 정답 or 오답을 확인")
    void checkScore() {
        // given
        Map<String, Integer> correctScore = Map.of("ball", 0, "strike", 3);
        Map<String, Integer> incorrectScore = Map.of("ball", 1, "strike", 0);

        // when
        boolean correctAnswer = result.analysis(correctScore);
        boolean incorrectAnswer = result.analysis(incorrectScore);

        // then
        Assertions.assertTrue(correctAnswer);
        Assertions.assertFalse(incorrectAnswer);
    }

    @Test
    @DisplayName("스코어를 보고 콘솔에 3strike 결과를 잘띄우는지 테스트")
    void check3Strike() {
        // given
        Map<String, Integer> strike3 = Map.of("ball", 0, "strike", 3);

        // when
        result.analysis(strike3);

        // then
        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("스코어를 보고 콘솔에 2strike 1ball 결과를 잘띄우는지 테스트")
    void check2Strike1ball() {
        // given
        Map<String, Integer> strike2ball2 = Map.of("ball", 1, "strike", 2);

        // when
        result.analysis(strike2ball2);

        // then
        assertThat(output()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    @DisplayName("스코어를 보고 콘솔에 2ball 결과를 잘띄우는지 테스트")
    void check2ball() {
        // given
        Map<String, Integer> ball2 = Map.of("ball", 2, "strike", 0);

        // when
        result.analysis(ball2);

        // then
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("스코어를 보고 콘솔에 nothing 결과를 잘띄우는지 테스트")
    void checkNothing() {
        // given
        Map<String, Integer> nothing = Map.of("ball", 0, "strike", 0);

        // when
        result.analysis(nothing);

        // then
        assertThat(output()).isEqualTo("낫싱");
    }

    @Override
    protected void runMain() {

    }
}