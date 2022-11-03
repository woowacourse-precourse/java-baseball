package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputChecker {
    public static boolean checkExceptionNumber(List<String> playersNumber) {
        Set<String> playersNumberSet = new HashSet<>(playersNumber);
        if (playersNumberSet.size() < playersNumber.size()) {    // 중복되는 숫자가 있는 경우
            return true;
        }

        if (playersNumber.size() != 3) {    // 입력된 숫자가 3자리수가 아닌 경우
            return true;
        }

        for (String number : playersNumber) {    // 입력된 숫자가 1 ~ 9 범위를 벗어나는 경우
            if (number.charAt(0) < "1".charAt(0) || number.charAt(0) > "9".charAt(0)) {
                return true;
            }
        }

        return false;
    }
}
