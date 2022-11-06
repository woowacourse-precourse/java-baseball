package baseball;

public class GameResult {
    int strike;
    int ball;

    public void printResult() {
        if (isUserWin()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (isNothing()) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public boolean isUserWin() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public void setGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}