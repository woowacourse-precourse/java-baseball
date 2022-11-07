package baseball;

public class BallCount {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";


    private BaseballNumbers inputBaseballNumbers;
    private int ball = 0;
    private int strike = 0;

    public void validateBallCount(BaseballNumbers randomNumbers, BaseballNumbers inputBaseballNumbers) {
        this.inputBaseballNumbers = inputBaseballNumbers;
        validateBall(randomNumbers);
        validateStrike(randomNumbers);
    }

    private void validateBall(BaseballNumbers randomNumbers) {
        for (int index = BaseballConstants.FIRST_INDEX_OF_BASEBALL_NUMBER; index < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER; index++) {
            validateBallInRandomNumbers(index, randomNumbers);
        }
    }

    private void validateBallInRandomNumbers(int index, BaseballNumbers randomNumbers) {
        for (int randomNumbersIndex = BaseballConstants.FIRST_INDEX_OF_BASEBALL_NUMBER; randomNumbersIndex < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER; randomNumbersIndex++) {
            if (index == randomNumbersIndex) {
                continue;
            }
            validateBallPlus(inputBaseballNumbers.get(index), randomNumbers.get(randomNumbersIndex));
        }
    }

    private void validateBallPlus(int inputNumber, int randomNUmber) {
        if (inputNumber == randomNUmber) {
            this.ball++;
        }
    }

    private void validateStrike(BaseballNumbers randomNumbers) {
        for (int index = BaseballConstants.FIRST_INDEX_OF_BASEBALL_NUMBER; index < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER; index++) {
            if (inputBaseballNumbers.get(index) == randomNumbers.get(index)) {
                this.strike++;
            }
        }
    }

}
