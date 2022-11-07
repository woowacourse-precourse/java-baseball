package baseball;

enum Score {
    GAME;

    private int ball;
    private int strike;
    Score() {
        resetScore();
    }

    private void resetScore() {
        ball = 0;
        strike = 0;
    }
}
