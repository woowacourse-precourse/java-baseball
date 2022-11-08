package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static baseball.ConstValue.*;

public class Score {
    public static final int NO_COUNT = 0;
    public static final int THREE_STRIKE_OUT = 3;
    private static final HashMap<String, Integer> totalScore = new HashMap<>();
    private static List<Integer> computerNumbers;
    private static List<Integer> userNumbers;
    public void userNumbers(List<Integer> users) {
        Score.userNumbers = users;
    }

    public static void makeScore() {
        Score.totalScore.put(STRIKE, getStrike());
        Score.totalScore.put(BALL, getBall());
    }
    public void computerNumbers(List<Integer> computers) {
        System.out.println("이번에 뽑은 숫자는: " + computers.get(0) + ": " + computers.get(1) + ": " + computers.get(2));
        Score.computerNumbers = computers;
    }

    public static Integer getValue(String key) {
        return totalScore.get(key);
    }

    public static HashMap<String, Integer> getTotalScore() {
        return totalScore;
    }

    private static Integer getStrike() {
        int strike = 0;
        for (int index = 0; index < NUMBERS_LENGTH; index++) {
            if (isStrike(index)) {
                strike += 1;
            }
        }
        return strike;
    }

    private static Integer getBall() {
        int ball = 0;
        for (int index = 0; index < NUMBERS_LENGTH; index++) {
            if (isBall(userNumbers.get(index)) && !isStrike(index)) {
                ball += 1;
            }
        }
        return ball;
    }

    private static boolean isStrike(int index) {
        return Objects.equals(computerNumbers.get(index), userNumbers.get(index));
    }

    private static boolean isBall(int userNumber) {
        return computerNumbers.contains(userNumber);
    }

    public static boolean threeStrikeOut() {
        return totalScore.get(STRIKE).equals(THREE_STRIKE_OUT);
    }

    public static boolean onlyBallCount() {
        return !totalScore.get(BALL).equals(NO_COUNT) && totalScore.get(STRIKE).equals(NO_COUNT);
    }

    public static boolean onlyStrikeCount() {
        return totalScore.get(BALL).equals(NO_COUNT) && !totalScore.get(STRIKE).equals(NO_COUNT);
    }

    public static boolean ballAndStrikeCount() {
        return !totalScore.get(BALL).equals(NO_COUNT) && !totalScore.get(STRIKE).equals(NO_COUNT);
    }

}
