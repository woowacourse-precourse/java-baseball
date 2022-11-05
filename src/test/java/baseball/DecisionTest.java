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
}