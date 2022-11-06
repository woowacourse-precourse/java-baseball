package baseball;

import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.domain.Balls;
import baseball.domain.PlayResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    Balls computerBalls;
    Balls playerBalls;

    @BeforeEach
    public void setUp() {
        Ball ball = Ball.of(1, 1);
        Ball ball2 = Ball.of(2, 2);
        Ball ball3 = Ball.of(3, 3);
        computerBalls = Balls.of(List.of(ball, ball2, ball3));
    }

    @Test
    public void 공_여러개_생성_테스트() throws Exception {

        assertThat(computerBalls.size()).isEqualTo(3);
    }

    @Test
    public void NOTHING_테스트() {
        Ball ball = Ball.of(4, 1);
        Ball ball2 = Ball.of(5, 2);
        Ball ball3 = Ball.of(6, 3);
        playerBalls = Balls.of(List.of(ball, ball2, ball3));
        PlayResult playResult = playerBalls.play(computerBalls);

        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
        assertThat(playResult.isNothing()).isTrue();

    }

    @Test
    public void ONE_STRIKE_ONE_BALL_테스트() {
        Ball ball = Ball.of(1, 1);
        Ball ball2 = Ball.of(5, 2);
        Ball ball3 = Ball.of(2, 3);
        playerBalls = Balls.of(List.of(ball, ball2, ball3));

        PlayResult playResult = playerBalls.play(computerBalls);

        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    public void THREE_STRIKE_테스트() {
        Ball ball = Ball.of(1, 1);
        Ball ball2 = Ball.of(2, 2);
        Ball ball3 = Ball.of(3, 3);
        playerBalls = Balls.of(List.of(ball, ball2, ball3));

        PlayResult playResult = playerBalls.play(computerBalls);

        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
        assertThat(playResult.isGameEnd()).isTrue();
    }

}