package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @Test
    public void nothingTest() {
        Ball computerBall = new Ball(1);
        assertThat(computerBall.judge(new Ball(2))).isEqualTo(Judgement.NOTHING);
    }
    @Test
    public void hasValueTest() {
        Ball computerBall = new Ball(1);
        assertThat(computerBall.judge(new Ball(1))).isEqualTo(Judgement.SAME_VALUE);
    }

}
