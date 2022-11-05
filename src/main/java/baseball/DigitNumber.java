package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public enum DigitNumber {

    INSTANCE;

    private int digit;

    DigitNumber() {

    }

    private void build(DigitNumberBuilder builder) {
        this.digit = builder.digit;
    }

    public static DigitNumber getInstance() {
        return INSTANCE;
    }

    public static class DigitNumberBuilder {

        private final int digit;

        private DigitNumberBuilder(int digit) {
            this.digit = digit;
        }

        public void build() {
            DigitNumber.INSTANCE.build(this);
        }

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
