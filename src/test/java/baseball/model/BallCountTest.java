package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BallCountTest {

    @Test
    void 볼카운트_결정() {
        Assertions.assertEquals(BallCount.STRIKE, BallCount.decideBallCount(true, true));
        Assertions.assertEquals(BallCount.BALL, BallCount.decideBallCount(true, false));
        Assertions.assertEquals(BallCount.NOTHING, BallCount.decideBallCount(false, false));
    }

    @Test
    void 올바른_display_반환() {
        Assertions.assertEquals("스트라이크", BallCount.STRIKE.getDisplay());
        Assertions.assertEquals("볼", BallCount.BALL.getDisplay());
        Assertions.assertEquals("낫싱", BallCount.NOTHING.getDisplay());

    }
}