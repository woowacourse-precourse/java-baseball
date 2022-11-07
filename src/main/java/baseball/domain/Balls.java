package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        balls = new ArrayList<>();
        Set<Integer> numberSet = setBallNumber(numbers);
        if (isOkaySize(numbers)) {
            throw new IllegalArgumentException();
        }

        if (isNotSameSize(numbers, numberSet)) {
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            balls.add(Ball.of(number, numbers.indexOf(number)));
        }
    }

    public static Balls from(List<Integer> numbers) {
        return new Balls(numbers);
    }

    public GameReport ballsMatch(Balls gamerBalls) {
        List<Ball> gamerBallList = gamerBalls.currentBalls();
        GameReport gameReport = new GameReport();
        for (Ball gamerBall : gamerBallList) {
            BallStatus ballStatus = ballMatching(gamerBall);
            gameReport.report(ballStatus);
        }
        return gameReport;
    }

    private BallStatus ballMatching(Ball givenBall) {
        return balls.stream()
            .map(ball -> ball.eachBallMatch(givenBall))
            .filter(BallStatus::isNotNothing)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    public List<Ball> currentBalls() {
        return balls;
    }

    private boolean isOkaySize(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    private boolean isNotSameSize(List<Integer> numbers, Set<Integer> numberSet) {
        return numbers.size() != numberSet.size();
    }

    private Set<Integer> setBallNumber(List<Integer> numbers) {
        Set<Integer> testNumbers = new HashSet<>();
        for (Integer number : numbers) {
            testNumbers.add(number);
        }
        return testNumbers;
    }


}
