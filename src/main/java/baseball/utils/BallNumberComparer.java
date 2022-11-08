package baseball.utils;

import static baseball.BaseballGame.INPUT_SIZE;

import baseball.domain.BallNumber;
import baseball.domain.Score;

public class BallNumberComparer {
    public Score calculateScore(BallNumber playerBallNumber, BallNumber computerBallNumber) {
        int strikeScore = calculateStrikeScore(playerBallNumber, computerBallNumber);
        int ballScore = calculateBallScore(playerBallNumber, computerBallNumber);
        return new Score(strikeScore, ballScore);
    }

    private int calculateStrikeScore(BallNumber playerBallNumber, BallNumber computerBallNumber) {
        int strikeScore = 0;
        for (int i = 0; i < INPUT_SIZE; ++i) {
            if (playerBallNumber.get(i).equals(computerBallNumber.get(i))) {
                ++strikeScore;
            }
        }
        return strikeScore;
    }

    /**
     * TODO: 2중 for문 refactoring 필요함.
     */
    private int calculateBallScore(BallNumber playerBallNumber, BallNumber computerBallNumber) {
        int ballScore = 0;
        for (int i = 0; i < INPUT_SIZE; ++i) {
            for (int j = 0; j < INPUT_SIZE; ++j) {
                if (i == j) {
                    continue;
                }

                if (playerBallNumber.get(i).equals(computerBallNumber.get(j))) {
                    ++ballScore;
                }
            }
        }
        return ballScore;
    }
}