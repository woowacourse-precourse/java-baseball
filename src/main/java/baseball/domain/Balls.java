package baseball.domain;

import baseball.utils.BallConvertor;

import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = BallConvertor.mapToBalls(balls);
    }

    public PlayResult compareTo(Balls computerBalls) {
        PlayResult playResult = new PlayResult();
        balls.stream()
                .map(computerBalls::compareTo)
                .forEach(playResult::updateResult);
        return playResult;
    }

    private BallStatus compareTo(Ball compareBall) {
        return balls.stream()
                .map(ball -> ball.compareTo(compareBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
