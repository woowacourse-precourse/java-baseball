package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallMatchVerifierTest {
    @Test
    void countStrike() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        assertThat(baseBallMatchCounter.countStrike(homeRun, input)).isEqualTo(1);
    }

    @Test
    void countBall() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        assertThat(baseBallMatchCounter.countBall(homeRun, input)).isEqualTo(2);
    }

    @Test
    void getListStrikeAndBall() {
        String homeRun = "123";
        String input = "321";
        BaseBallMatchCounter baseBallMatchCounter = new BaseBallMatchCounter();
        assertThat(baseBallMatchCounter.getBallGameResult(homeRun, input)).isEqualTo(List.of(1, 2));
    }
}
