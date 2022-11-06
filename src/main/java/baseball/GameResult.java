package baseball;

public class GameResult {
    int strike;
    int ball;

    public boolean isUserWin() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}