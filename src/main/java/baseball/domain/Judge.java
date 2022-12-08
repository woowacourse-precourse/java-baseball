package baseball.domain;

import java.util.stream.IntStream;

import static baseball.utils.BaseBallStatus.BASEBALL_DEFAULT_SIZE;

public class Judge {

    private final Answer computer;
    private static final int ANSWER_SIZE = BASEBALL_DEFAULT_SIZE.getCode();

    Judge(Answer computer) {
        this.computer = computer;
    }

    public ScoreBoard getScoreBoard(Answer user) {
        int ballCount = getBallCount(user);
        int strikeCount = getStrikeCount(user);

        return new ScoreBoard(ballCount, strikeCount);
    }

    private int getBallCount(Answer user) {
        return getContainsNumberCount(user) - getStrikeCount(user);
    }

    private int getContainsNumberCount(Answer user) {
        return (int) IntStream.range(0, ANSWER_SIZE)
                .map(user::get)
                .filter(computer::contains)
                .count();
    }

    private int getStrikeCount(Answer user) {
        return (int) IntStream.range(0, ANSWER_SIZE)
                .filter(index -> computer.get(index) == user.get(index))
                .count();
    }
}
