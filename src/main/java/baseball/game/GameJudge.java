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

        Digit firstInput = playerInput.first;
        Digit secondInput = playerInput.second;
        Digit thirdInput = playerInput.third;

        boolean isFirstBall = !firstInput.equals(randomNumber.first) && randomNumber.contains(firstInput),
                isSecondBall = !secondInput.equals(randomNumber.second) && randomNumber.contains(secondInput),
                isThirdBall = !thirdInput.equals(randomNumber.third) && randomNumber.contains(thirdInput);

        if (isFirstBall) {
            ballCount++;
        }
        if (isSecondBall) {
            ballCount++;
        }
        if (isThirdBall) {
            ballCount++;
        }

        return ballCount;
    }

    public GameResult countAndMakeResult(GameNumber answerNumber, GameNumber playerInputNumber) {
        int ballCount = countBall(answerNumber, playerInputNumber);
        int strikeCount = countStrike(answerNumber, playerInputNumber);
        return new GameResult(ballCount, strikeCount);
    }
}
