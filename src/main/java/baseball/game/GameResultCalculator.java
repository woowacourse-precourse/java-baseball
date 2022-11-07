package baseball.game;

import baseball.input.GameInput;

public class GameResultCalculator {
    public boolean isThreeStrike(Number computer, Number player) {
        return player.equals(computer);
    }

    public int countStrike(Number randomNumber, GameInput playerInput) {
        int strikeCount = 0;

        if (randomNumber.first.equals(playerInput.number.first)) {
            strikeCount++;
        }
        if (randomNumber.second.equals(playerInput.number.second)) {
            strikeCount++;
        }
        if (randomNumber.third.equals(playerInput.number.third)) {
            strikeCount++;
        }
        return strikeCount;
    }

    public int countBall(Number randomNumber, GameInput playerInput) {
        int ballCount = 0;

        Digit firstInput = playerInput.number.first;
        Digit secondInput = playerInput.number.second;
        Digit thirdInput = playerInput.number.third;

        boolean isFirstBall = firstInput != randomNumber.first && randomNumber.contains(firstInput),
                isSecondBall = secondInput != randomNumber.second && randomNumber.contains(secondInput),
                isThirdBall = thirdInput != randomNumber.third && randomNumber.contains(thirdInput);

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
}
