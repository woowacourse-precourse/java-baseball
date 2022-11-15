package baseball.game;

import baseball.game.number.Digit;
import baseball.game.number.GameNumber;

public class GameJudge {
    public boolean isThreeStrike(GameNumber computer, GameNumber player) {
        return player.equals(computer);
    }

    private int countStrike(GameNumber randomNumber, GameNumber playerInput) {
        int strikeCount = 0;

        if (randomNumber.first.equals(playerInput.first)) {
            strikeCount++;
        }
        if (randomNumber.second.equals(playerInput.second)) {
            strikeCount++;
        }
        if (randomNumber.third.equals(playerInput.third)) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int countBall(GameNumber randomNumber, GameNumber playerInput) {
        int ballCount = 0;

        if (isFirstBall(randomNumber, playerInput)) {
            ballCount++;
        }
        if (isSecondBall(randomNumber, playerInput)) {
            ballCount++;
        }
        if (isThirdBall(randomNumber, playerInput)) {
            ballCount++;
        }

        return ballCount;
    }

    private boolean isThirdBall(GameNumber randomNumber, GameNumber playerInput) {
        return !playerInput.third.equals(randomNumber.third) && randomNumber.contains(playerInput.third);
    }

    private boolean isSecondBall(GameNumber randomNumber, GameNumber playerInput) {
        return !playerInput.second.equals(randomNumber.second) && randomNumber.contains(playerInput.second);
    }

    private boolean isFirstBall(GameNumber randomNumber, GameNumber playerInput) {
        return !playerInput.first.equals(randomNumber.first) && randomNumber.contains(playerInput.first);
    }

    public GameResult countAndMakeResult(GameNumber answerNumber, GameNumber playerInputNumber) {
        int ballCount = countBall(answerNumber, playerInputNumber);
        int strikeCount = countStrike(answerNumber, playerInputNumber);
        return new GameResult(ballCount, strikeCount);
    }
}
