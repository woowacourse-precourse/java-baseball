package baseball;


public class MatchResult {

    int ball;
    int strike;

    public MatchResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void print() {
        if (ball > 0) {
            System.out.print(this.ball + "볼");
        }
        if (this.ball > 0 && this.strike > 0) {
            System.out.print(" ");
        }
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크");
        }
        if (this.strike == 0 && this.ball == 0) {
            System.out.print("낫싱");
        }
        System.out.print(System.lineSeparator());
    }

    public boolean isCorrect() {
        return (this.strike == 3);
    }
}
