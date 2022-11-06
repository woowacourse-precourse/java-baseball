package baseball.gamescore;

public class Ball {
    public int score(int correctCount, int strike) {
        return correctCount - strike;
    }
}
