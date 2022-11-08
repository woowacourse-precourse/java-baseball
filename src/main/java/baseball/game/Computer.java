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
    private final Output output;

    public Computer() {
        this.ballGenerator = new BallGenerator();
        this.output = new Output();
    }

    public List<Integer> getComputerBalls() {
        return ballGenerator.createComputerBalls();
    }

    public void countStrikeAndBallResults(List<Integer> computerBalls, List<Integer> playerBalls,
            List<Integer> strikeAndBallResults) {
        playerBalls.stream()
                .filter(ball -> computerBalls.stream().anyMatch(Predicate.isEqual(ball)))
                .forEach(ball -> updateStrikeAndBallResults(strikeAndBallResults,
                        getCount(playerBalls.indexOf(ball) == computerBalls.indexOf(ball),
                                strikeAndBallResults.get(STRIKE_COUNT)),
                        getCount(playerBalls.indexOf(ball) != computerBalls.indexOf(ball),
                                strikeAndBallResults.get(BALL_COUNT))));
    }

    private void updateStrikeAndBallResults(List<Integer> strikeAndBallResults, int strikeCount, int ballCount) {
        strikeAndBallResults.set(STRIKE_COUNT, strikeCount);
        strikeAndBallResults.set(BALL_COUNT, ballCount);
    }

    private int getCount(boolean condition, int count) {
        if (condition) {
            count++;
        }
        return count;
    }

    public String getResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == COMPUTER_BALLS_SIZE) {
            return SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER;
        }
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + SystemMessage.BALL + " " + strikeCount + SystemMessage.STRIKE;
        }
        if (strikeCount == 0 && ballCount > 0) {
            return ballCount + SystemMessage.BALL;
        }
        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + SystemMessage.STRIKE;
        }
        return SystemMessage.NOTHING;
    }

    public void printResultMessage(String resultMessage) {
        output.printMessage(resultMessage);
    }
}
