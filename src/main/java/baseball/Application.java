package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> getThreeRandomNumber() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < 3) {
            int tmpRandomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(tmpRandomNumber)) {
                result.add(tmpRandomNumber);
            }
        }
        return result;
    }

    private static boolean isValidBaseballNumber(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char number : input.toCharArray()) {
            if (number > '9' || number < '0') {
                return false;
            }
        }

        return true;
    }
}
