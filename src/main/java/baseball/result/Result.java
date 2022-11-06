package baseball.result;

public class Result {
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(String randomNumber, String userNumber) {
        for (int index = 0; index < randomNumber.length(); index++) {
            if (randomNumber.charAt(index) == userNumber.charAt(index)) {
                strike++;
            }
        }
    }

    public void countBall(String randomNumber, String userNumber){

    }

    public void countBall() {

    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean istNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
