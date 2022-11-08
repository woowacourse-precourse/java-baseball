package baseball.utility;

import baseball.dto.Score;

public class ResultEvaluator {

    private ResultEvaluator() {

    }

    private static Score getScore(String computerNumber, String playerNumber) {
        int numberLength = playerNumber.length();
        int numStrikes = 0;
        int numBalls = 0;

        for (int i = 0; i < numberLength; i++) {
            numStrikes += isStrikeOrNot(computerNumber, playerNumber, i);
            numBalls += isBallOrNot(computerNumber, playerNumber, i);
        }

        return new Score(numBalls, numStrikes);
    }

    private static int isStrikeOrNot(String computerNumber, String playerNumber, int index) {
        if (computerNumber.charAt(index) == playerNumber.charAt(index)) {
            return 1;
        }
        return 0;
    }

    private static int isBallOrNot(String computerNumber, String playerNumber, int index) {
        int numberLength = playerNumber.length();
        int iteratingIndex = (index + 1) % numberLength;
        int count = 0;

        while (count < numberLength - 1 && (playerNumber.charAt(index) != computerNumber.charAt(iteratingIndex))) {
            iteratingIndex = (iteratingIndex + 1) % numberLength;
            count++;
        }

        if (count == numberLength - 1) {
            return 0;
        }
        return 1;
    }
}
