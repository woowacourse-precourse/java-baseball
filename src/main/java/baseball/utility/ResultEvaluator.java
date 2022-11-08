package baseball.utility;

import baseball.dto.Score;

public class ResultEvaluator {
    private static final String TEXT_FOR_NO_SCORE = "낫싱";
    private static final String TEXT_FOR_BALL = "볼";
    private static final String TEXT_FOR_STRIKE = "스트라이크";

    private ResultEvaluator() {

    }

    public static String getHint(String computerNumber, String playerNumber) {
        assert (PlayerNumberValidator.isPlayerNumberValid(computerNumber) && PlayerNumberValidator.isPlayerNumberValid(playerNumber));
        assert (computerNumber.length() == playerNumber.length());

        return translateScoreToHint(getScore(computerNumber, playerNumber));
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

    public static String translateScoreToHint(Score score) {
        int numBalls = score.getBallCount();
        int numStrikes = score.getStrikeCount();

        if (numBalls == 0 && numStrikes == 0) {
            return TEXT_FOR_NO_SCORE;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (numBalls != 0) {
            String ballText = String.format("%d%s ", numBalls, TEXT_FOR_BALL);
            stringBuilder.append(ballText);
        }

        if (numStrikes != 0) {
            String strikeText = String.format("%d%s ", numStrikes, TEXT_FOR_STRIKE);
            stringBuilder.append(strikeText);
        }

        return stringBuilder.toString().trim();
    }
}
