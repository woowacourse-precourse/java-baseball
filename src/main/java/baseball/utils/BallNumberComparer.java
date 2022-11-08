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

    private int calculateBallScore(BallNumber playerBallNumber, BallNumber computerBallNumber) {
        int ballScore = 0;
        for (int i = 0; i < INPUT_SIZE; ++i) {
            int indexOfComputerBallNumber = computerBallNumber.indexOf(playerBallNumber.get(i));
            if (indexOfComputerBallNumber != i && indexOfComputerBallNumber != -1) {
                ++ballScore;
            }
        }
        return ballScore;
    }
}