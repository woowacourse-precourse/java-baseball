package baseball.domain;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int ANSWER_STRIKE_COUNT = 3;
    private int ball;
    private int strike;

    public Score() {
        initBallAndStrike();
    }

    private void initBallAndStrike() {
        this.ball = INITIAL_VALUE;
        this.strike = INITIAL_VALUE;
    }

    public boolean isWrongAnswer(String answer, int[] guessedAnswer) {
        initBallAndStrike();

        for (int guessedAnswerIndex = 0; guessedAnswerIndex < guessedAnswer.length; guessedAnswerIndex++) {
            int number = guessedAnswer[guessedAnswerIndex];
            int answerIndex = answer.indexOf(number);

            ballAndStrikeCount(answerIndex, guessedAnswerIndex);
        }

        if (strike == ANSWER_STRIKE_COUNT) {
            return false;
        }

        return true;
    }

    private void ballAndStrikeCount(int answerIndex, int guessedAnswerIndex) {
        if (answerIndex == guessedAnswerIndex) {
            strike++;
        }

        if (answerIndex != guessedAnswerIndex) {
            ball++;
        }
    }

    private int[] getBallAndStrike() {
        int[] ballAndStrike = {ball, strike};
        return ballAndStrike;
    }
}
