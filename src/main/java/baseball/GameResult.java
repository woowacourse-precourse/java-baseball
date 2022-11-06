package baseball;

public class GameResult {
    int strike;
    int ball;

    public boolean isUserWin() {
        return strike == 3;
    }
}