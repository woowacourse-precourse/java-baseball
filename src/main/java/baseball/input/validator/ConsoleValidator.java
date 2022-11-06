package baseball.input.validator;

import java.util.Set;

public class ConsoleValidator implements Validator {

    @Override
    public void validateAnswer(String input) throws IllegalArgumentException {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("입력은 숫자만 허용합니다. : " + input);
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리를 입력해야 합니다. : " + input);
        }

        Set<String> answerNumberSet = Set.of(input.split(""));
        if (answerNumberSet.size() != 3) {
            throw new IllegalArgumentException("입력은 숫자에 중복이 없어야 합니다. : " + input);
        }
    }

    @Override
    public void validateRetryable(String input) throws IllegalArgumentException {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("입력은 숫자만 허용합니다. : " + input);
        }

        if (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2) {
            throw new IllegalArgumentException("입력은 1 또는 2를 입력해야 합니다. : " + input);
        }

    }

    private boolean isNotNumeric(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
