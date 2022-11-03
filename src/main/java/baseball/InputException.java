package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputChecker {
    public static void checkExceptionNumber(List<String> playersNumber) {
        Set<String> playersNumberSet = new HashSet<>(playersNumber);
        if (playersNumberSet.size() < playersNumber.size()) {
            throw new IllegalArgumentException("중복되는 숫자를 입력했습니다.");
        }

        if (playersNumber.size() != 3) {
            throw new IllegalArgumentException("입력된 숫자가 3자리수가 아닙니다.");
        }

        for (String number : playersNumber) {
            if (number.charAt(0) < "1".charAt(0) || number.charAt(0) > "9".charAt(0)) {
                throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
            }
        }
    }
}
