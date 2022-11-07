package baseball;

public class Response {
    private int strike;
    private int ball;

    boolean isCompleted = Boolean.FALSE;

    public Response(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void view() {
        if (strike == 3) {
            printIsAnswer();
            this.isCompleted = Boolean.TRUE;
            return;
        } else if (strike == 0 && ball == 0) {
            printBallAndStrikeIsZero();
            return;
        } else if (strike == 0) {
            printBallIsNotZero(ball);
            System.out.println();
            return;
        } else if (ball == 0) {
            printStrikeIsNotZero(ball);
            System.out.println();
            return;
        }
        printBallIsNotZero(ball);
        System.out.print(" ");
        printStrikeIsNotZero(strike);
        System.out.println();
    }

    private void printIsAnswer() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printStrikeIsNotZero(int strike) {
        if (strike == 0) {
            return;
        }
        System.out.print(strike +"스트라이크");
    }

    private void printBallIsNotZero(int ball) {
        if (ball == 0) {
            return;
        }
        System.out.print(ball +"볼");
    }

    private void printBallAndStrikeIsZero() {
        System.out.println("낫싱");
    }


}
