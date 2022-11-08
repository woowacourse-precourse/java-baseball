package baseball.rule;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.BallCount;
import baseball.rule.EndRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EndRuleTest {

    @Test
    @DisplayName("볼카운트 3스트라이크시 게임종료 true 반환")
    void 볼카운트_3스크라이크시_게임종료_true() {
        BallCount ballCount = new BallCount(3, 0);
        boolean isGameEnd = EndRule.isGameEnd(ballCount);
        assertThat(isGameEnd).isEqualTo(true);
    }

    @Test
    @DisplayName("볼카운트 2스크라이크 1볼시 게임종료 false 반환")
    void 볼카운트_2스크라이크_1볼시_게임종료_false() {
        BallCount ballCount = new BallCount(2, 1);
        boolean isGameEnd = EndRule.isGameEnd(ballCount);
        assertThat(isGameEnd).isEqualTo(false);
    }

    @Test
    @DisplayName("유저가 1 입력시 프로그램 종료 false 반환")
    void 유저_1입력시_프로그램종료_false() {
        boolean isProgramEnd = EndRule.isProgramEnd("1");
        assertThat(isProgramEnd).isEqualTo(false);
    }

    @Test
    @DisplayName("유저가 2 입력시 프로그램 종료 true 반환")
    void 유저_2입력시_프로그램종료_true() {
        boolean isProgramEnd = EndRule.isProgramEnd("2");
        assertThat(isProgramEnd).isEqualTo(true);
    }
}
