package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    public Validator() {

    }

    public void validateRange(int ball) {
        if (ball < 1 || ball > 9) {
            throw new IllegalArgumentException("1~9사이의 값을 입력해야 합니다");
        }
    }

    public void validateLength(List<Ball> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
    }

    public void validRestartIndex(String restartIndex) {
        if (!restartIndex.equals("1") && !restartIndex.equals("2")) {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }
    }

    public void validateDuplicate(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해야 합니다.");
        }
    }

    public void validateType(String[] humanInput) {
        String pattern = "^[0-9]*$";
        for (int i = 0; i < humanInput.length; i++) {
            if (!Pattern.matches(pattern, humanInput[i])) {
                throw new IllegalArgumentException("숫자만 입력해야합니다.");
            }
        }
    }
}
