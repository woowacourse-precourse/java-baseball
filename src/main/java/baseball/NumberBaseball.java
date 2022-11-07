package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberBaseball {
    private static int getRandomThreeDigitNumber() {
        List<Integer> possible = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int ret = 0;

        for (int chooseCount = 0; chooseCount < 3; chooseCount++) {
            int randomNumber = Randoms.pickNumberInRange(0, (8 - chooseCount));
            ret *= 10;
            ret += possible.remove(randomNumber);
        }
        return ret;
    }
    private static boolean isCorrectNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        if (number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2)
                || number.charAt(0) == number.charAt(2)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!('1' <= number.charAt(i) && number.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
    private static String judgeBallCount(String num1, String num2) {
        int strike = 0;
        int ball = 0;
        String ret = "";

        for (int i = 0; i < 3; i++) {
            if (num1.charAt(i) == num2.charAt(i)) {
                strike++;
            } else if (num1.indexOf(num2.charAt(i)) >= 0) {
                ball++;
            }
        }
        if (ball > 0) {
            ret += String.format("%d볼 ", ball);
        }
        if (strike > 0) {
            ret += String.format("%d스트라이크 ", strike);
        }
        if (ball == 0 && strike == 0) {
            ret = "낫싱";
        }
        return ret.trim();
    }
}
