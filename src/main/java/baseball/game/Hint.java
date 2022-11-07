package baseball.game;

import static baseball.common.Constants.MAX_NUMBER_COUNT;


public class Hint {
    private int strike;
    private int ball;

    public Hint() {

    }

    public void setHint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void printHint() {
        if (isNoting()) {
            System.out.print("낫싱");
        }
        if (isBall()) {
            System.out.print(ball + "볼 ");
        }
        if (isStrike()) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    private boolean isStrike() {
        return strike > 0;
    }

    private boolean isBall() {
        return ball > 0;
    }

    private boolean isNoting() {
        return strike == 0 && ball == 0;
    }

    private void countBall(int digit, int[] answer, int playerAnswer) {
        for (int i = 0; i < MAX_NUMBER_COUNT; i++) {
            if (i != digit && answer[i] == playerAnswer){
                this.ball++;
            }
        }
    }

    private void countStrike(int answer, int playerAnswer) {
        if (answer == playerAnswer){
            this.strike++;
        }
    }
    
}

