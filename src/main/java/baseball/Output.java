package baseball;

public class Output {

    public void printDecisionResult(int strike, int ball) {
        printStrikeOnly(strike, ball);
        printBallOnly(strike, ball);
        printBallAndStrike(strike, ball);
        printNothing(strike, ball);
    }

    public void printStrikeOnly(int strike, int ball) {
        if(strike > 0 && ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        }
    }

    public void printBallOnly(int strike, int ball) {
        if(strike == 0 && ball > 0) {
            System.out.println(String.format("%d볼", ball));
        }
    }

    public void printBallAndStrike(int strike, int ball) {
        if(strike > 0 && ball > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
    }

    public void printNothing(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
}
