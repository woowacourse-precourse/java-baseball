package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DecisionTest {
    Decision decision;

    @BeforeEach
    public void init() {
        decision = new Decision();
    }

    @DisplayName("스트라이크 개수 세기 테스트")
    @Test
    void countStrike() {
        List<Integer> computerNumbers = List.of(1, 2, 5);
        List<Integer> userNumbers = List.of(1, 2, 3);

        int strike = decision.countStrike(userNumbers, computerNumbers);

        Assertions.assertThat(strike).isEqualTo(2);
    }

    @DisplayName("볼 개수 세기 테스트")
    @Test
    void countBall() {
        List<Integer> computerNumbers = List.of(3, 1, 2);
        List<Integer> userNumbers = List.of(1, 2, 3);

        int ball = decision.countBall(userNumbers, computerNumbers);

        Assertions.assertThat(ball).isEqualTo(3);
    }

    @DisplayName("3스트라이크 판정 테스트")
    @Test
    void isThreeStrike() {
        int strike = 3;

        boolean isCorrect = decision.isThreeStrike(strike);

        Assertions.assertThat(isCorrect).isTrue();
    }

    @DisplayName("3스트라이크 아닌 경우 판정 테스트")
    @Test
    void isNotThreeStrike() {
        int strike = 2;

        boolean isCorrect = decision.isThreeStrike(strike);

        Assertions.assertThat(isCorrect).isFalse();
    }
}