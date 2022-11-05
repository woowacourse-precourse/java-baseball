package baseball.gamescore;

public class Ball {
    public int score(int correctCount, int strike) {
        int ball = correctCount - strike;
        return ball;
    }
}
