package baseball;

import constant.Const;

public class Hint {
    public int strike;
    private int ball;

    public void getHint(int[] userNumber, int[] computerNumber) {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < Const.NUMBER_LENGTH; i++) {
            countStrike(userNumber[i], computerNumber[i]);
            countBall(userNumber[i], computerNumber, i);
        }

        printHint();
    }

    private void printHint() {
        printBall();
        printStrike();
        printNothing();
        System.out.println();
    }

    private void printBall() {
        if (this.ball > 0) {
            System.out.print(this.ball + "볼 ");
        }
    }

    private void printStrike() {
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크 ");
        }
    }

    private void printNothing(){
        if (this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }
    }
    private void countStrike(int user, int computer) {
        if (user == computer) {
            this.strike++;
        }
    }
    private void countBall(int user, int[] computerNumber, int presentIndex) {
        for (int i = 0; i < Const.NUMBER_LENGTH; i++) {
            if (presentIndex != i && computerNumber[i] == user){
                this.ball++;
            }
        }
    }
}
