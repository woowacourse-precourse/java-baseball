package baseball.game;

import baseball.game.number.Digit;
import baseball.game.number.Number;
import java.util.List;

public class GameResultCalculator {
    public boolean isThreeStrike(Number computer, Number player) {
        return player.equals(computer);
    }

    private int countStrike(Number randomNumber, Number playerInput) {
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

    private int countBall(Number randomNumber, Number playerInput) {
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

    public List<Integer> getResult(Number answerNumber, Number playerInputNumber) {
        int ballCount = countBall(answerNumber, playerInputNumber);
        int strikeCount = countStrike(answerNumber, playerInputNumber);
        return List.of(ballCount, strikeCount);
    }
}
