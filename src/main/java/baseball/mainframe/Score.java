package baseball.mainframe;

import baseball.view.GameOutput;

public class Score {

    private int strikeCount;
    private int ballCount;
    private final int NUMBER_LENGTH = 3;
    private final int ZERO_COUNT = 0;

    public void setCountToZero() {
        strikeCount = ZERO_COUNT;
        ballCount = ZERO_COUNT;
    }

    public void countBallAndStrike(String userInput, String answer) {
        setCountToZero();
        for (int userInputIndex = 0; userInputIndex < NUMBER_LENGTH; userInputIndex++) {
            if (answer.contains(Character.toString(userInput.charAt(userInputIndex)))
                    && answer.indexOf(Character.toString(userInput.charAt(userInputIndex)))
                    == userInputIndex) {
                strikeCount++;
            } else if (answer.contains(Character.toString(userInput.charAt(userInputIndex)))
                    && answer.indexOf(Character.toString(userInput.charAt(userInputIndex)))
                    != userInputIndex) {
                ballCount++;
            }
        }
    }

    public void printScore() {
        if (strikeCount == ZERO_COUNT && ballCount == ZERO_COUNT) {
            GameOutput.printNothing();
        } else if (ballCount != ZERO_COUNT && strikeCount != ZERO_COUNT) {
            GameOutput.printBallAndStrike(ballCount, strikeCount);
        } else if (strikeCount == ZERO_COUNT) {
            GameOutput.printBall(ballCount);
        } else if (ballCount == ZERO_COUNT) {
            GameOutput.printStrike(strikeCount);
        }
    }
}
