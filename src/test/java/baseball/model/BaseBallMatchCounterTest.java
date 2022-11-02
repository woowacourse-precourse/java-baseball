package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallMatchCounterTest {
    @Test
    void countStrike() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        Map<BaseBallResultType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallResultType.STRIKE)).isEqualTo(1);
    }

    @Test
    void countBall() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        Map<BaseBallResultType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallResultType.BALL)).isEqualTo(2);
    }

    @Test
    void countNoting() {
        String homeRun = "456";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        Map<BaseBallResultType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallResultType.NOTING)).isEqualTo(3);
    }
}
