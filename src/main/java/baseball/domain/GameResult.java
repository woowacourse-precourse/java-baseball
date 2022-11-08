package baseball.domain;

public class GameResult {
    private static final int TARGET_STRIKE = 3;
    private int ball = 0;
    private int strike = 0;
    private GameState state = GameState.NOTHING;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public GameState getState() {
        return state;
    }

    public void addStrike() {
        strike++;
        if (isCorrect()) {
            state = GameState.CORRECT;
        } else {
            numberAtLeastOnce();
        }
    }

    public void addBall() {
        ball++;
        numberAtLeastOnce();
    }

    // addStrike 또는 addBall이 한번이라도 실행되었으면 NOTHING에서 GOOD으로 상태를 변환하는 함수
    private void numberAtLeastOnce() {
        state = GameState.GOOD;
    }

    private boolean isCorrect() {
        return strike == TARGET_STRIKE;
    }
}
