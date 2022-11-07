package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    public void ballSizeExceptionTest() throws Exception {
        List<Integer> integers = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> Balls.from(integers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ballSameNumberExceptionTest() throws Exception {
        List<Integer> integers = List.of(7, 7, 8);
        assertThatThrownBy(() -> Balls.from(integers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ballsSettingTest() throws Exception {
        List<Integer> integers = List.of(1, 2, 3);
        Ball ball01 = Ball.of(1, 0);
        Ball ball02 = Ball.of(2, 1);
        Ball ball03 = Ball.of(3, 2);
        assertThat(Balls.from(integers).currentBalls()).containsExactly(ball01, ball02, ball03);
    }

    @Test
    public void ballsOneStrikeOneBallTest() throws Exception {
        List<Integer> ball01 = List.of(1, 2, 3);
        List<Integer> ball02 = List.of(1, 3, 9);
        Balls computerBalls = Balls.from(ball01);
        Balls userBalls = Balls.from(ball02);
        GameReport gameReport = computerBalls.ballsMatch(userBalls);
        gameReport.printCurrentGameCount();
    }

    @Test
    public void threeStrikeTest() throws Exception {
        List<Integer> ball01 = List.of(1, 3, 5);
        List<Integer> ball02 = List.of(1, 3, 5);
        Balls computerBalls = Balls.from(ball01);
        Balls userBalls = Balls.from(ball02);
        GameReport gameReport = computerBalls.ballsMatch(userBalls);
        gameReport.printCurrentGameCount();
    }

}
