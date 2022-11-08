package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final int NUMBER_OF_BALLS = 3;
    private static final String REPLAY = "1";
    private static final String OVER = "2";

    private final Hitter hitter;
    private final Pitcher pitcher;

    public BaseballGame(Hitter hitter, Pitcher pitcher) {
        this.hitter = hitter;
        this.pitcher = pitcher;
    }

    public void playGame() {
        System.out.println(BaseballMessage.GAME_START_MESSAGE.getMessage());
        while (playInning()) { }
    }

    private boolean playInning() {
        Balls pitcherBalls = pitcher.throwRandomBalls(NUMBER_OF_BALLS);
        while (true) {
            Balls hitterBalls = hitter.hitBalls(hitter.inputNumber());
            int strikeCount = pitcherBalls.getStrikeCount(hitterBalls);
            int ballCount = pitcherBalls.getBallCount(hitterBalls);
            printResult(strikeCount, ballCount);

            if (isGameOver(strikeCount)) {
                return isReplaying();
            }
        }
    }

    private boolean isGameOver(int strikeCount) {
        if (strikeCount == NUMBER_OF_BALLS) {
            System.out.println(NUMBER_OF_BALLS + BaseballMessage.GAME_OVER_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    private boolean isReplaying() {
        System.out.println(BaseballMessage.REPLAY_MESSAGE.getMessage());
        String number = Console.readLine();

        if (number.equals(REPLAY)) {
            return true;
        }

        if (number.equals(OVER)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private void printResult(int strikeCount, int ballCount) {
        printBallCount(ballCount);
        printStrikeCount(strikeCount);
        printNothing(ballCount, strikeCount);
        System.out.println();
    }

    private void printBallCount(int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + BaseballMessage.BALL_COUNT_MESSAGE.getMessage());
        }
    }

    private void printStrikeCount(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(strikeCount + BaseballMessage.STRIKE_COUNT_MESSAGE.getMessage());
        }
    }

    private void printNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(BaseballMessage.NOTHING_MESSAGE.getMessage());
        }
    }
}
