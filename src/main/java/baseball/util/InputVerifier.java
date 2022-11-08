package baseball.util;

import baseball.domain.RandomNumberGenerator;
import java.util.List;

public class InputVerifier {

    String input;

    private static final int RETRY_NUMBER = 1;
    private static final int END_NUMBER = 2;

    public InputVerifier(String input) {
        this.input = input;
    }

    public boolean isRetryNumber() {
        int inputToInteger = Integer.parseInt(input);
        return inputToInteger == RETRY_NUMBER;
    }

    public boolean isEndNumber() {
        int inputToInteger = Integer.parseInt(input);
        return inputToInteger == END_NUMBER;
    }

    public boolean notRetryOrEndNumber() {
        int inputToInteger = Integer.parseInt(input);
        return inputToInteger != RETRY_NUMBER && inputToInteger != END_NUMBER;
    }

    public boolean isInteger() {
        for (int i = 0; i < input.length(); i++) {
            char needVerify = input.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }

        return true;
    }

    public boolean isSizeValid() {
        List<Integer> inputArray = StringToArrayList.convert(input);
        return inputArray.size() == RandomNumberGenerator.SIZE;
    }

    public boolean notContainZero() {
        List<Integer> inputArray = StringToArrayList.convert(input);
        return !inputArray.contains(0);
    }

    public boolean isUnique() {
        List<Integer> inputArray = StringToArrayList.convert(input);
        return inputArray.size() == inputArray.stream().distinct().count();
    }
}
