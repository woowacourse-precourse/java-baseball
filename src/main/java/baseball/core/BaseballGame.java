package baseball.core;

import org.junit.jupiter.api.Test;

public class BaseballGame {

    // 1-1. 볼의 개수 확인
    public Integer countTheNumberOfBall(String targetNumber, String inputNumber) {

        Integer numberOfBall = 0;
        for (int indexOfInput = 0; indexOfInput < inputNumber.length(); indexOfInput++) {
            char digitOfInput = inputNumber.charAt(indexOfInput);
            if (isBall(targetNumber, indexOfInput, digitOfInput)) numberOfBall++;
        }

        return numberOfBall;
    }

    // 해당 자리의 숫자가 볼인지 확인
    private Boolean isBall(String targetNumber, int indexOfInput, char digitOfInput) {
        for (int indexOfTarget = 0; indexOfTarget < targetNumber.length(); indexOfTarget++) {
            char digitOfTarget = targetNumber.charAt(indexOfTarget);
            if (indexOfTarget == indexOfInput) continue;
            if (digitOfTarget == digitOfInput) return true;
        }
        return false;
    }
}
