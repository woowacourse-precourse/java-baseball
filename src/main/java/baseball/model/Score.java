package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    public static final int INPUT_LENGTH = 3;
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    private List<Integer> score;

    public List<Integer> getScore(List<Integer> userAnswer, List<Integer> correctAnswer) {
        score = new ArrayList<>();
        score.add(getStrikeNum(userAnswer, correctAnswer));
        score.add(getBallNum(userAnswer, correctAnswer));
        return score;
    }

    private int getStrikeNum(List<Integer> userAnswer, List<Integer> correctAnswer) {
        int strikeNum = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (userAnswer.get(i) == correctAnswer.get(i)) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private int getBallNum(List<Integer> userAnswer, List<Integer> correctAnswer) {
        return getContainNum(userAnswer, correctAnswer) - score.get(STRIKE_INDEX);
    }

    private int getContainNum(List<Integer> userAnswer, List<Integer> correctAnswer) {
        int containNum = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (correctAnswer.contains(userAnswer.get(i))) {
                containNum++;
            }
        }
        return containNum;
    }
}
