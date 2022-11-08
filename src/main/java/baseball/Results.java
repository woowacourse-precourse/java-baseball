package baseball;

public class Results {

    public static final int COUNT_CRITERIA = 0;
    public static final int THREE_STRIKE_CRITERIA_COUNT = 3;

    public static boolean isThreeStrike(int strike) {
        return strike == THREE_STRIKE_CRITERIA_COUNT;
    }

    public static boolean isNothing(int total) {
        return total == COUNT_CRITERIA;
    }

    public static boolean isBall(int total, int strike) {
        return total > COUNT_CRITERIA && strike == COUNT_CRITERIA;
    }

    public static boolean isStrike(int total, int ball) {
        return total > COUNT_CRITERIA && ball == COUNT_CRITERIA;
    }

    public static boolean isBallStrike(int total, int ball, int strike) {
        return total > COUNT_CRITERIA && ball > COUNT_CRITERIA && strike > COUNT_CRITERIA;
    }

}
