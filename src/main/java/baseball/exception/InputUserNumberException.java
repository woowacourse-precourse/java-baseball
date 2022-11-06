package baseball.exception;

import java.util.HashSet;
import java.util.Set;


public class InputUserNumberException {

    private final int PROPER_LENGTH = 3;


    private void checkInputSizeThreeNumber(String userNumber) {
        if (userNumber.length() != PROPER_LENGTH) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
    }

    private void checkInputNotOverlapNumber(String userNumber) {
        Set<Integer> userNumberSet = new HashSet<>();
        for (int index = 0; index < userNumber.length(); index++) {
            userNumberSet.add(userNumber.charAt(index) - '0');
        }
        if (userNumberSet.size() != PROPER_LENGTH) {
            throw new IllegalArgumentException("숫자에 중복이 있으면 안됩니다.");
        }
    }


}
