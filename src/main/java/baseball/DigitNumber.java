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

    private static class DigitNumberBuilder {

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

    public Map<Integer, Integer> convertNumberToMap(int digitNumber) {
        Map<Integer, Integer> userNumber = new HashMap<>();

        for (int index = digit - 1; index >= 0; ) {
            int number = getDigitNumberOf(digitNumber, index);
            userNumber.put(number, index);
        }

        return userNumber;
    }

    private int getDigitNumberOf(int digitNumber, int index) {
        int pow = (int) Math.pow(10, index);
        int number = digitNumber / pow;
        return number % pow;
    }

}
