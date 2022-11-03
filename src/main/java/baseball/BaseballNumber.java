package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    public static List<Integer> create() {
        List<Integer> baseballNumber = new ArrayList<>();

        while (baseballNumber.size() < 3) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(digit)) {
                baseballNumber.add(digit);
            }
        }

        return baseballNumber;
    }

    public static int countStrike(List<Integer> baseballNumber, List<Integer> inputNumber) {
        int count = 0;
        for (Integer digit : baseballNumber) {
            int baseballIndex = baseballNumber.indexOf(digit);
            int inputIndex = inputNumber.indexOf(digit);
            if (inputNumber.contains(digit) && baseballIndex == inputIndex) {
                count++;
            }
        }
        return count;
    }

    public static int countBall(List<Integer> baseballNumber, List<Integer> inputNumber) {
        return 0;
    }

    public static void printMessage(int strike, int ball) {

    }
}
