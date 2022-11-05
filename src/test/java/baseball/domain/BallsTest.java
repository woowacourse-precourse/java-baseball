package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    @Test
    public void ballsTest() {
        Balls computerBalls = new Balls(List.of(1,2,3));
        assertThat(computerBalls.play(new Ball(4))).isEqualTo(Judgement.NOTHING);
    }
}
