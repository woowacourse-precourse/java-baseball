package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static List<Integer> compareWithInput(String input, List<Integer> computer) {
        List<Integer> result = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - '0';
            if (cur == computer.get(i)) {
                strike++;
                continue;
            }

            if (computer.contains(cur)) {
                ball++;
            }
        }
        result.add(ball);
        result.add(strike);
        return result;
    }

    static String resultToString(List<Integer> compareResult) {
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

    static List<Integer> createNewValue() {
        List<Integer> newValue = new ArrayList<>();
        while (newValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newValue.contains(randomNumber)) {
                newValue.add(randomNumber);
            }
        }
        return newValue;
    }
}
