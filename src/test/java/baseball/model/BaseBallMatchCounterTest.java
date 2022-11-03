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
        Map<BaseBallHitsType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallHitsType.STRIKE)).isEqualTo(1);
    }

    @Test
    void countBall() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        Map<BaseBallHitsType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallHitsType.BALL)).isEqualTo(2);
    }

    @Test
    void countNoting() {
        String homeRun = "456";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        Map<BaseBallHitsType, Integer> matchResult = baseBallMatchCounter.getMatchResult(homeRun, input);
        assertThat(matchResult.get(BaseBallHitsType.NOTING)).isEqualTo(3);
    }
}
