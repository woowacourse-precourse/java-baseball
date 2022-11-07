package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

    public void validateGuessInput(String input) throws IllegalArgumentException {
        if (!isParsableToInteger(input)) {
            throw new IllegalArgumentException("잘못된 입력! 3자리 양의 정수를 입력해주세요.");
        }

        int inputNum = Integer.parseInt(input);

        if (inputNum < 100 || inputNum > 999) {
            throw new IllegalArgumentException("잘못된 입력! 3자리 양의 정수를 입력해주세요.");
        }

        if (!hasUniqueDigits(inputNum)) {
            throw new IllegalArgumentException("잘못된 입력! 각 자리수가 서로 달라야 합니다.");
        }
    }

    public boolean hasUniqueDigits(int num) {
        if (num == 0) {
            return true;
        }

        Set<Integer> digitSet = new HashSet<>();
        int lengthOfNum = 0;

        while (num != 0) {
            digitSet.add(num % 10);
            num /= 10;
            lengthOfNum++;
        }

        return digitSet.size() == lengthOfNum;
    }

    public boolean isParsableToInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
