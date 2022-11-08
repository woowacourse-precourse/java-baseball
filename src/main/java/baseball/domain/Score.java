package baseball.domain;

import baseball.view.OutputView;

import java.util.List;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int ANSWER_STRIKE_COUNT = 3;
    private static final int NOT_FOUND_INDEX = -1;

    private int ball;
    private int strike;

    public Score() {
        initBallAndStrike();
    }

    private void initBallAndStrike() {
        ball = INITIAL_VALUE;
        strike = INITIAL_VALUE;
    }

    public boolean isWrongAnswer(List<Integer> answer, List<Integer> guessedAnswer) {
        initBallAndStrike();

        for (int guessedAnswerIndex = INITIAL_VALUE; guessedAnswerIndex < guessedAnswer.size(); guessedAnswerIndex++) {
            int number = guessedAnswer.get(guessedAnswerIndex);
            int answerIndex = answer.indexOf(number);

            ballAndStrikeCount(answerIndex, guessedAnswerIndex);
        }

        setResultMessage(ball, strike);

        return strike != ANSWER_STRIKE_COUNT;
    }

    private void ballAndStrikeCount(int answerIndex, int guessedAnswerIndex) {
        if (answerIndex == guessedAnswerIndex) {
            strike++;

        } else if (answerIndex > NOT_FOUND_INDEX) {
            ball++;
        }
    }

    private void setResultMessage(int ball, int strike) {
        if (ball == INITIAL_VALUE && strike == INITIAL_VALUE) {
            OutputView.setNothingMessage();
        }

        if (ball > INITIAL_VALUE && strike == INITIAL_VALUE) {
            OutputView.setOnlyBallMessage(ball);
        }

        if (ball == INITIAL_VALUE && strike > INITIAL_VALUE) {
            OutputView.setOnlyStrikeMessage(strike);
        }

        if (ball > INITIAL_VALUE && strike > INITIAL_VALUE) {
            OutputView.setBallAndStrikeMessage(ball, strike);
        }
    }
}
