package baseball.game;


import static baseball.constant.SystemValue.BALL_COUNT;
import static baseball.constant.SystemValue.COMPUTER_BALLS_SIZE;
import static baseball.constant.SystemValue.STRIKE_COUNT;

import baseball.constant.SystemMessage;
import baseball.util.BallGenerator;
import java.util.List;
import java.util.function.Predicate;

public class Computer {

    private final BallGenerator ballGenerator;

    public Computer() {
        this.ballGenerator = new BallGenerator();
    }

    public List<Integer> getComputerBalls() {
        return ballGenerator.createComputerBalls();
    }

    public void calculateStrikeAndBallCounts(List<Integer> computerBalls, List<Integer> playerBalls, List<Integer> strikeAndBallCounts) {
        playerBalls.stream()
                .filter(ball -> computerBalls.stream().anyMatch(Predicate.isEqual(ball)))
                .forEach(ball -> updateStrikeAndBallCounts(strikeAndBallCounts,
                        getCount(playerBalls.indexOf(ball) == computerBalls.indexOf(ball),
                                strikeAndBallCounts.get(STRIKE_COUNT)),
                        getCount(playerBalls.indexOf(ball) != computerBalls.indexOf(ball),
                                strikeAndBallCounts.get(BALL_COUNT))));
    }

    private void updateStrikeAndBallCounts(List<Integer> strikeAndBallCounts, int strikeCount, int ballCount) {
        strikeAndBallCounts.set(STRIKE_COUNT, strikeCount);
        strikeAndBallCounts.set(BALL_COUNT, ballCount);
    }

    private int getCount(boolean condition, int count) {
        if (condition) {
            count++;
        }
        return count;
    }

    public String getResultMessage(int strikeCnt, int ballCnt) {
        if (strikeCnt == COMPUTER_BALLS_SIZE) {
            return SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER;
        }
        if (strikeCnt > 0 && ballCnt > 0) {
            return ballCnt + SystemMessage.BALL + " " + strikeCnt + SystemMessage.STRIKE;
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            return ballCnt + SystemMessage.BALL;
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            return strikeCnt + SystemMessage.STRIKE;
        }
        return SystemMessage.NOTHING;
    }
}
