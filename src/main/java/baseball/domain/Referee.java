package baseball.domain;

import java.util.List;

public class Referee {

    private final RandomNumberGenerator randomNumberGenerator;
    private final BallCount ballCount;
    public Referee() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.ballCount = new BallCount();
    }

    private final static int START = 1;
    private final static int END = 9;
    private List<Integer> randomNumber;

    public void generateRandomNumber() {
        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumber();
        this.randomNumber = randomNumber;
    }

    public void compareNumbers(List<Integer> userNumber) {
        ballCount.initBallCount();
        for(int i = 0; i < 3; i++) {
            int userDigits = userNumber.get(i);
            checkDigits(userDigits, i);
        }
    }

    private void checkDigits(int userDigits, int i) {
        for(int j = 0; j < 3; j++) {
            int computerDigits = randomNumber.get(j);
            if(userDigits == computerDigits && i == j) {
                ballCount.increaseStrike();
            }else if(userDigits == computerDigits) {
                ballCount.increaseBall();
            }
        }
    }

    public String returnResult() {
        return ballCount.makeResultString();
    }

    public boolean isGameClear() {
        return ballCount.isStrikeThree();
    }

}
