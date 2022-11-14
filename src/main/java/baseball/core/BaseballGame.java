package baseball.core;

public class BaseballGame {

    private String targetNumber;
    private GameStatus currentStatus;

    public BaseballGame(String targetNumber, GameStatus currentStatus) {
        this.targetNumber = targetNumber;
        this.currentStatus = currentStatus;
    }

    // 볼의 개수 확인
    public Integer countTheNumberOfBall(String targetNumber, String inputNumber) {

        Integer numberOfBall = 0;
        for (int indexOfInput = 0; indexOfInput < inputNumber.length(); indexOfInput++) {
            char digitOfInput = inputNumber.charAt(indexOfInput);
            if (isBall(targetNumber, indexOfInput, digitOfInput)) numberOfBall++;
        }

        return numberOfBall;
    }

    // 스트라이크의 개수 확인
    public Integer countTheNumberOfStrike(String targetNumber, String inputNumber) {

        Integer numberOfStrike = 0;
        for (int indexOfInput = 0; indexOfInput < inputNumber.length(); indexOfInput++) {
            char digitOfInput = inputNumber.charAt(indexOfInput);
            if (isStrike(targetNumber, indexOfInput, digitOfInput)) numberOfStrike++;
        }

        return numberOfStrike;
    }

    //== 입력 숫자에서 각 자릿수마다 볼인지 스트라인지 확인 ==//
    // 해당 자릿수가 볼이면 true, 볼이 아니면 false를 반환
    private Boolean isBall(String targetNumber, int indexOfInput, char digitOfInput) {
        for (int indexOfTarget = 0; indexOfTarget < targetNumber.length(); indexOfTarget++) {
            char digitOfTarget = targetNumber.charAt(indexOfTarget);
            if (indexOfTarget == indexOfInput) continue;
            if (digitOfTarget == digitOfInput) return true;
        }
        return false;
    }

    // 해당 자릿수가 스트라이크면 true, 스트라이크가 아니면 false를 반환
    private Boolean isStrike(String targetNumber, int indexOfInput, char digitOfInput) {
        int indexOfTarget = indexOfInput;
        char digitOfTarget = targetNumber.charAt(indexOfTarget);
        if (digitOfTarget == digitOfInput) return true;
        return false;
    }

    //== Getter & Setter ==//
    public String getTargetNumber() {
        return targetNumber;
    }
    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }
    public GameStatus getCurrentStatus() {
        return currentStatus;
    }
    public void setCurrentStatus(GameStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
