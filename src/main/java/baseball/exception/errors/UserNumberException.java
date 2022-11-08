package baseball.exception.errors;

import java.util.ArrayList;
import java.util.List;

public class UserNumberException {
    public void exception(int input) {
        if (String.valueOf(input).length() != 3) {
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.");
        }
        if (String.valueOf(input).contains("0")) {
            throw new IllegalArgumentException("입력된 숫자가 1에서 9 사이 숫자가 아닙니다.");
        }
        if (checkDuplicate(input)) {
            throw new IllegalArgumentException("입력된 숫자가 중복되었습니다.");
        }
    }

    private boolean checkDuplicate(int input) {
        List<Integer> userNumbers = new ArrayList<>();
        while (input == 0) {
            userNumbers.add(input % 10);
            input /= 10;
        }
        return userNumbers.size() < 3;
    }
}
