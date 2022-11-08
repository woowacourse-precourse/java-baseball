package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int NUMBER_LENGTH = 3;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    public static List<Integer> compareWithInput(String input, List<Integer> computerValue) {
        List<Integer> result = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int cur = input.charAt(i) - '0';
            if (cur == computerValue.get(i)) {
                strike++;
                continue;
            }

            if (computerValue.contains(cur)) {
                ball++;
            }
        }
        result.add(ball);
        result.add(strike);
        return result;
    }

    public static String resultToString(List<Integer> compareResult) {
        String result = "";
        if (compareResult.get(0) != 0) {
            result += compareResult.get(0) + "볼 ";
        }
        if (compareResult.get(1) != 0) {
            result += compareResult.get(1) + "스트라이크";
        }
        if (result.equals("")) {
            result = "낫싱";
        }
        return result.strip();
    }

    public static List<Integer> createNewValue() {
        List<Integer> newValue = new ArrayList<>();
        while (newValue.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!newValue.contains(randomNumber)) {
                newValue.add(randomNumber);
            }
        }
        return newValue;
    }
}
