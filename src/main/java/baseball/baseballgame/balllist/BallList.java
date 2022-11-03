package baseball.baseballgame.balllist;

import baseball.baseballgame.ball.Ball;
import baseball.baseballgame.ball.BallNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BallList {

    private final List<Ball> ballList;

    public BallList() {
        this.ballList = new ArrayList<>();
    }


    public BallList(List<Integer> userBallList) {
        this.ballList = userBallList.stream()
                .map(BallNumber::new)
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public void add(Ball ball) {
        ballList.add(ball);
    }


    public void add(List<Ball> userBallList) {
        ballList.addAll(userBallList);
    }


    public boolean contains(Ball ball) {
        return ballList.contains(ball);
    }

    public BallReport judge(BallList comBallList) {
        BallReport ballReport = new BallReport();
        for (int position = 0; position < 3; position++) {
            ballReport.add(comBallList.judge(position, ballList.get(position), ballList));
        }
        return ballReport;
    }

    private JudgementType judge(int position, Ball computerBall, List<Ball> computerBallList) {
        Ball ball = ballList.get(position);
        if (ball.equals(computerBall)) {
            return JudgementType.STRIKE;
        }
        if (computerBallList.contains(ball)) {
            return JudgementType.BALL;
        }
        return JudgementType.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallList)) {
            return false;
        }
        BallList ballList1 = (BallList) o;
        return Objects.equals(ballList, ballList1.ballList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }
}
