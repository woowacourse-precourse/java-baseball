package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BaseballGame {
    private static final int NUMBER_OF_BALLS = 3;
    private static final String REPLAY = "1";
    private static final String OVER = "2";
    private static final String INVALID_NUMBER_RANGE_REGEX = "[^1-9]";

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
            Balls hitterBalls = hitter.hitBalls(inputNumber());
            int strikeCount = pitcherBalls.getStrikeCount(hitterBalls);
            int ballCount = pitcherBalls.getBallCount(hitterBalls);
            printResult(strikeCount, ballCount);

            if (isGameOver(strikeCount)) {
                return isReplaying();
            }
        }
    }

    public String inputNumber() {
        System.out.print(BaseballMessage.INPUT_NUMBER_MESSAGE.getMessage());
        String number = Console.readLine();
        validate(number);
        return number;
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

    private void validate(String number) {
        validateNumberLength(number);
        validateNumberRange(number);
        validateNumberDuplication(number);
    }

    private void validateNumberLength(String number) {
        if (number.length() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + BaseballMessage.INVALID_NUMBER_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(String number) {
        if (Pattern.compile(INVALID_NUMBER_RANGE_REGEX).matcher(number).find()) {
            throw new IllegalArgumentException(BaseballMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void validateNumberDuplication(String number) {
        if (IntStream.range(0, 10)
                .anyMatch(digit -> isDuplicated(number, digit))) {
            throw new IllegalArgumentException(BaseballMessage.DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private boolean isDuplicated(String number, int digit) {
        return getDigitCount(number, digit) >= 2;
    }

    private long getDigitCount(String number, int digit) {
        return Arrays.stream(number.split(""))
                .filter(digitString -> digitString.equals(String.valueOf(digit)))
                .count();
    }
}
