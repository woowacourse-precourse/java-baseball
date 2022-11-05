package baseball.utils;

import java.util.List;

public class NumberCalculator {
    private static List<Integer> computerNumber;
    private static List<Integer> userNumber;
    private static int strike;
    private static int ball;

    public NumberCalculator(List<Integer> computerNumber, List<Integer> userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
        strike = 0;
        ball = 0;
    }

    public void resultCalculator() {
        for (int i = 0; i < computerNumber.size(); i++) {
            isNumber(i, userNumber.get(i));
        }
    }

    private void isNumber(int index, int userNumber) {
        if (computerNumber.contains(userNumber)) {
            isSamePlace(index, userNumber);
        }
    }

    private void isSamePlace(int index, int userNumber) {
        if (computerNumber.get(index) == userNumber) {
            strike++;
        } else {
            ball++;
        }
    }
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
