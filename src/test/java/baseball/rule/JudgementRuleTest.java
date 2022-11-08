package baseball.rule;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.strategy.FixedNumberProducingStrategy;
import baseball.strategy.NumberProducingStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgementRuleTest {

    NumberProducingStrategy numberProducingStrategy = new FixedNumberProducingStrategy();

    @Test
    @DisplayName("컴퓨터숫자 123 유저숫자 123 볼카운트 판단시 3스트라이크 객체와 동등성 성립")
    void 컴퓨터숫자_123_유저숫자_123_볼카운트_동등성_비교() {
        Numbers computerNumbers = new Numbers(numberProducingStrategy.produceNumbers());
        Numbers userNumbers = new Numbers(List.of(1, 2, 3));
        BallCount userBallCount = JudgementRule.makeBallCounts(computerNumbers, userNumbers);
        assertThat(userBallCount).usingRecursiveComparison().isEqualTo(new BallCount(3, 0));
    }

    @Test
    @DisplayName("컴퓨터숫자 123 유저숫자 213 볼카운트 판단시 1스트라이크 2볼 객체와 동등성 성립")
    void 컴퓨터숫자_123_유저숫자_213_볼카운트_동등성_비교() {
        Numbers computerNumbers = new Numbers(numberProducingStrategy.produceNumbers());
        Numbers userNumbers = new Numbers(List.of(2, 1, 3));
        BallCount userBallCount = JudgementRule.makeBallCounts(computerNumbers, userNumbers);
        assertThat(userBallCount).usingRecursiveComparison().isEqualTo(new BallCount(1, 2));
    }

}
