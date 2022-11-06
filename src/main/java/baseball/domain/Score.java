package baseball.domain;

import baseball.view.OutputView;

import java.util.Arrays;

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

    public boolean isWrongAnswer(Integer[] answer, Integer[] guessedAnswer) {
        initBallAndStrike();

        for (int guessedAnswerIndex = 0; guessedAnswerIndex < guessedAnswer.length; guessedAnswerIndex++) {
            int number = guessedAnswer[guessedAnswerIndex];
            int answerIndex = Arrays.asList(answer).indexOf(number);

            ballAndStrikeCount(answerIndex, guessedAnswerIndex);
        }

        setResultMessage(ball, strike);

        return strike != ANSWER_STRIKE_COUNT;
    }

    private void ballAndStrikeCount(int answerIndex, int guessedAnswerIndex) {
        if (answerIndex == guessedAnswerIndex) {
            strike++;

        } else if (answerIndex > -1) {
            ball++;
        }
    }

    private void setResultMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            OutputView.setNothingMessage();
        }

        if (ball > 0 && strike == 0) {
            OutputView.setOnlyBallMessage(ball);
        }

        if (ball == 0 && strike > 0) {
            OutputView.setOnlyStrikeMessage(strike);
        }

        if (ball > 0 && strike > 0) {
            OutputView.setBallAndStrikeMessage(ball, strike);
        }
    }
}
