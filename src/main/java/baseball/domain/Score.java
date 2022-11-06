package baseball.domain;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private int ball;
    private int strike;

    public Score() {
        this.ball = INITIAL_VALUE;
        this.strike = INITIAL_VALUE;
    }

    private void ballAndStrikeCount(int answerIndex, int guessedAnswerInder) {
        if (answerIndex == guessedAnswerInder) {
            strike++;
        }

        if (answerIndex != guessedAnswerInder) {
            ball++;
        }
    }

    private int[] getBallAndStrike() {
        int[] ballAndStrike = {ball, strike};
        return ballAndStrike;
    }
}
