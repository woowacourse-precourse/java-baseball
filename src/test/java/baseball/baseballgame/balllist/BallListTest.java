package baseball.baseballgame.balllist;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.baseballgame.ball.Ball;
import baseball.baseballgame.ball.BallNumber;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class BallListTest {

    @Test
    void add_ball() {
        BallList ballList = new BallList();
        Ball ball3 = new Ball(BallNumber.createBallNumber(3));
        ballList.add(ball3);
        assertThat(ballList.contains(ball3)).isTrue();

        Ball ball4 = new Ball(BallNumber.createBallNumber(4));
        ballList.add(ball4);
        assertThat(ballList.contains(ball4)).isTrue();
    }

    @Test
    void return_judgement_type_report() {
        List<Ball> ballListCase1 = IntStream.range(1, 4)
                .mapToObj(BallNumber::createBallNumber)
                .map(Ball::new)
                .collect(toList());

        BallList computerBallList = new BallList();
        computerBallList.add(ballListCase1);

        BallList userBallList = new BallList(ballListCase1);
        BallReport judge = computerBallList.judge(userBallList);

        BallReport ballReportStrikeCase = new BallReport();
        ballReportStrikeCase.add(JudgementType.STRIKE, 3);

        assertThat(judge).isEqualTo(ballReportStrikeCase);

    }
}
