package baseball.baseballgame.balls;

import static baseball.baseballgame.balls.Balls.BALLS_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.baseballgame.ball.Ball;
import baseball.baseballgame.ball.BallNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void add_ball() {
        Balls balls = new Balls(List.of(3, 4, 5));
        Ball ball3 = new Ball(BallNumber.createBallNumber(3));
        assertThat(balls.contains(ball3)).isTrue();

        Ball ball4 = new Ball(BallNumber.createBallNumber(4));
        assertThat(balls.contains(ball4)).isTrue();
    }

    @Test
    void return_judgement_type_report() {

        Balls computerBalls = new Balls(List.of(1, 2, 3));

        Balls userBalls = new Balls(List.of(1, 2, 3));
        BallReport ballReport = computerBalls.judge(userBalls);

        BallReport ballReportStrikeCase = new BallReport();
        ballReportStrikeCase.add(JudgementType.STRIKE);

        assertThat(ballReport.reportToList()).isEqualTo(List.of(3, 0, 0));
    }


    @Test
    void range_error() {
        assertThatThrownBy(() -> new Balls(List.of(1, 2))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALLS_RANGE_ERROR);

        assertThatThrownBy(() -> new Balls(List.of(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALLS_RANGE_ERROR);
    }
}
