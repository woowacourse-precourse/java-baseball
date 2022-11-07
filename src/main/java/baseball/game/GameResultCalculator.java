package baseball.game;

public class GameResultCalculator {
    public boolean isThreeStrike(Number computer, Number player) {
        return player.equals(computer);
    }

    public int countStrike(Number randomNumber, Number playerInput) {
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

    public int countBall(Number randomNumber, Number playerInput) {
        int ballCount = 0;

        Digit firstInput = playerInput.first;
        Digit secondInput = playerInput.second;
        Digit thirdInput = playerInput.third;

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
