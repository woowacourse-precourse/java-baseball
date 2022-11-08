package baseball.exception;

import java.util.HashSet;
import java.util.Set;


public class InputUserNumberException {

    private final int PROPER_LENGTH = 3;

    public void findUserNumberException(String userNumber) {
        checkInputSizeThreeNumber(userNumber);
        checkInputNumberRange(userNumber);
        checkInputNotOverlapNumber(userNumber);
    }

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

    private void checkInputNumberRange(String userNumber) {
        for (int index = 0; index < userNumber.length(); index++) {
            if (userNumber.charAt(index) - '0' < 1 || userNumber.charAt(index) - '0' > 9) {
                throw new IllegalArgumentException("1~9의 숫자를 대입해주세요");
            }
        }
    }


    public void checkInputRestartNumber(String choiceRestartNumber) {
        int choiceRestartNumberToInt = Integer.parseInt(choiceRestartNumber);
        if (!(choiceRestartNumberToInt == 1 || choiceRestartNumberToInt == 2)) {
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
        }
    }


}
