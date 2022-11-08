package baseball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.result.PlayResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallsTest {

    Balls computerBalls;
    Balls playerBalls;

    @BeforeEach
    public void setUp() {
        computerBalls = Balls.of(List.of(1, 2, 3));
    }

    @Test
    public void 매개변수_길이_검증() {
        assertThatThrownBy(
            () -> Balls.of(List.of(1))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> Balls.of(List.of(1, 2))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> Balls.of(List.of(1, 2, 3, 4))
        ).isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> Balls.of(List.of(1, 2, 3)));
    }

    @Test
    public void 매개변수_중복_검증() {
        assertThatThrownBy(
            () -> Balls.of(List.of(7, 7, 7))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> Balls.of(List.of(7, 1, 7))
        ).isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> Balls.of(List.of(1, 2, 3)));
    }

    @Test
    public void NOTHING_테스트() {
        playerBalls = Balls.of(List.of(4, 5, 6));

        PlayResult playResult = playerBalls.play(computerBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
        assertThat(playResult.isNothing()).isTrue();
    }

    @Test
    public void ONE_STRIKE_ONE_BALL_테스트() {
        playerBalls = Balls.of(List.of(1, 5, 2));

        PlayResult playResult = playerBalls.play(computerBalls);
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    public void THREE_STRIKE_테스트() {
        playerBalls = Balls.of(List.of(1, 2, 3));

        PlayResult playResult = playerBalls.play(computerBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
        assertThat(playResult.isGameEnd()).isTrue();
    }

}