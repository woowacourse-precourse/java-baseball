package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputValidator {

    public static void isValidBalls(List<Integer> balls) {
        isValidInputSize(balls.size());
        hasDuplicateNumber(balls);
    }

    public static void isValidBallNo(char ballNo) {
        isDigit(ballNo);
        isNotZero(ballNo);
    }

    private static void isValidInputSize(int inputSize) {
        if (inputSize != 3) {
            throw new IllegalArgumentException("입력 숫자는 총 3개여야 합니다.");
        }
    }

    private static void hasDuplicateNumber(List<Integer> balls) {
        Set<Integer> duplicateChecker = new HashSet<>(balls);
        if (duplicateChecker.size() != 3) {
            throw new IllegalArgumentException("입력 숫자 중 중복된 숫자는 존재할 수 없습니다.");
        }
    }

    private static void isDigit(char ballNo) {
        if (!Character.isDigit(ballNo)) {
            throw new IllegalArgumentException("입력은 숫자만 허용합니다.");
        }
    }

    private static void isNotZero(char ballNo) {
        if (ballNo == 48) {
            throw new IllegalArgumentException("입력은 1 ~ 9 사이의 수만 허용합니다.");
        }
    }
}
