package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

    private Ball computerBall = null;

    @BeforeEach
    void setUp() {
        computerBall = Ball.of(3, 1);
    }

    @Test
    public void ballBallTest() throws Exception {
        assertThat(Ball.of(3, 2).eachBallMatch(computerBall))
            .isEqualTo(BallStatus.BALL);
    }

    @Test
    public void ballStrikeTest() throws Exception {
        assertThat(Ball.of(3, 1).eachBallMatch(computerBall))
            .isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ballNothingTest() throws Exception {
        assertThat(Ball.of(4, 2).eachBallMatch(computerBall))
            .isEqualTo(BallStatus.NOTHING);
    }

}
