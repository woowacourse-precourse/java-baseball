package baseball.domain;

import baseball.utils.Constants;
import java.util.List;

public class Judge {
    private final Answer answer;

    public Judge(Answer answer) {
        this.answer = answer;
    }

    public boolean isStrike(int inputNumber, int index) {
        return answer.isContain(inputNumber) && answer.getIndex(inputNumber) == index;
    }

    public boolean isBall(int inputNumber, int index) {
        return answer.isContain(inputNumber) && answer.getIndex(inputNumber) != index;
    }

    public int getStrikeCount(List<Integer> userInput) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.VALID_LENGTH; i++) {
            if (isStrike(userInput.get(i), i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> userInput) {
        int ballCount = 0;
        for (int i = 0; i < Constants.VALID_LENGTH; i++) {
            if (isBall(userInput.get(i), i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public Score getUserInputScore(List<Integer> userInput) {
        return new Score(getStrikeCount(userInput), getBallCount(userInput));
    }
}

