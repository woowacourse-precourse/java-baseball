package baseball.core;

public class BaseballNumber {

    private String targetNumber;

    public BaseballNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public int countTheNumberOfBall(String inputNumber) {

        Integer numberOfBall = 0;
        for (int indexOfInput = 0; indexOfInput < inputNumber.length(); indexOfInput++) {
            char digitOfInput = inputNumber.charAt(indexOfInput);
            if (checkWhetherBall(indexOfInput, digitOfInput)) numberOfBall++;
        }
        return numberOfBall;
    }

    public int countTheNumberOfStrike(String inputNumber) {

        Integer numberOfStrike = 0;
        for (int indexOfInput = 0; indexOfInput < inputNumber.length(); indexOfInput++) {
            char digitOfInput = inputNumber.charAt(indexOfInput);
            if (checkWhetherStrike(indexOfInput, digitOfInput)) numberOfStrike++;
        }

        return numberOfStrike;
    }

    //== 입력 숫자의 각 자릿수마다 볼인지 스트라인지 확인 ==//
    /**
     * 해당 자릿수가 볼이면 true, 볼이 아니면 false를 반환하는 메서드
     * @param indexOfInput 숫자의 자리
     * @param digitOfInput 해당 자릿수
     * @return boolean
     */
    private boolean checkWhetherBall(int indexOfInput, char digitOfInput) {
        for (int indexOfTarget = 0; indexOfTarget < targetNumber.length(); indexOfTarget++) {
            char digitOfTarget = targetNumber.charAt(indexOfTarget);
            if (indexOfTarget == indexOfInput) continue;
            if (digitOfTarget == digitOfInput) return true;
        }
        return false;
    }

    /**
     * 해당 자릿수가 스트라이크면 true, 스트라이크가 아니면 false를 반환하는 메서드
     * @param indexOfInput 숫자의 자리
     * @param digitOfInput 해당 자릿수
     * @return boolean
     */
    private boolean checkWhetherStrike(int indexOfInput, char digitOfInput) {
        int indexOfTarget = indexOfInput;
        char digitOfTarget = targetNumber.charAt(indexOfTarget);
        if (digitOfTarget == digitOfInput) return true;
        return false;
    }
}
