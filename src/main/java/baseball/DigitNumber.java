package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class DigitNumber {

    private static Integer initValue;
    private final int digit;

    private static class DigitNumberHolder {
        private static final DigitNumber INSTANCE = new DigitNumber(initValue);
    }

    private DigitNumber(int digit) {
        this.digit = digit;
    }

    public static DigitNumber getInstance(int digit) {
        DigitNumber.initValue = digit;
        DigitNumber instance = DigitNumberHolder.INSTANCE;
        DigitNumber.initValue = null;
        return instance;
    }

    public Map<Integer, Integer> generateDigitNumberWithoutDuplication() {
        Map<Integer, Integer> computerNumber = new HashMap<>();

        for (int index = 0; index < digit; ) {
            int picked = Randoms.pickNumberInRange(1, 9);

            if (computerNumber.containsKey(picked)) {
                continue;
            }

            computerNumber.put(picked, index++);
        }

        return computerNumber;
    }

    public Map<Integer, Integer> convertNumberToMap(String userNumberStr) throws IllegalArgumentException {
        Validator.isVaildNumber(userNumberStr, digit);
        Map<Integer, Integer> userNumber = new HashMap<>();

        for (int i = 0; i < digit; i++) {
            int current = userNumberStr.charAt(i) - '0';
            userNumber.put(current, i);
        }

        return userNumber;
    }

}
