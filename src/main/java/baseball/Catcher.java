package baseball;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

import baseball.utils.NumberGenerator;
import java.util.List;

public class Catcher {

    private List<Integer> answer;

    private final NumberGenerator numberGenerator;

    public Catcher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        initRandomNumbers();
    }

    private void initRandomNumbers() {
        answer = numberGenerator.generateNumber();
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public GameResult catching(Integer[] pitch) {
        int ballCount = getBallCount(pitch);
        int strikeCount = getStrikeCount(pitch);
        return new GameResult(ballCount, strikeCount);
    }

    private int getBallCount(Integer[] pitch) {
        int ballCount = 0;
        for (int answerOrder = 0; answerOrder < GAME_NUMBER_LENGTH; answerOrder++) {
            ballCount += isBall(pitch[answerOrder], answerOrder);
        }
        return ballCount;
    }

    private int isBall(Integer pitch, int answerOrder) {
        int pitchIndexAnswerContains = answer.indexOf(pitch);
        if (pitchIndexAnswerContains < 0 || pitchIndexAnswerContains == answerOrder) {
            return 0;
        }
        return 1;
    }

    private int getStrikeCount(Integer[] pitch) {
        int strikeCount = 0;
        for (int answerOrder = 0; answerOrder < GAME_NUMBER_LENGTH; answerOrder++) {
            strikeCount += isStrike(answer.get(answerOrder), pitch[answerOrder]);
        }
        return strikeCount;
    }

    private int isStrike(Integer answer, Integer pitch) {
        if (answer.equals(pitch)) {
            return 1;
        }
        return 0;
    }
}
