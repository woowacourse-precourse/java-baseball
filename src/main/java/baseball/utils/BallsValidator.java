package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class BallsValidator {

    String userInput;

    public BallsValidator(String userInput) {
        this.userInput = userInput;
        validate(userInput);
    }

    private void validate(String userInput) {
        validateLength(userInput);
        validateType(userInput);
        validateRange(userInput);
        validateDuplicate(userInput);
    }

    private void validateDuplicate(String userInput) {
        Set<String> inputSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            inputSet.add(String.valueOf(userInput.charAt(i)));
        }
        if(inputSet.size()!=3){
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해야 합니다.");
        }
    }

    private void validateRange(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (Integer.parseInt(String.valueOf(userInput.charAt(i))) == 0) {
                throw new IllegalArgumentException("[ERROR] 1~9 사이의 숫자만 입력해야 합니다.");
            }
        }
    }

    private void validateLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 세 자리 숫자로 이루어진 값을 입력해주세요.");
        }
    }

    private void validateType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
