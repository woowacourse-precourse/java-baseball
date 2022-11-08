package baseball.catcher;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

import baseball.GameResult;
import baseball.catcher.util.NumberGenerator;
import java.util.List;

public class Catcher {

    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;
    private List<Integer> answer;
    private final NumberGenerator numberGenerator;

    public Catcher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void initRandomNumbers() {
        answer = numberGenerator.generateNumber();
    }

    public GameResult catching(List<Integer> pitch) {
        int ballCount = getBallCount(pitch);
        int strikeCount = getStrikeCount(pitch);
        return new GameResult(ballCount, strikeCount);
    }

    private int getBallCount(List<Integer> pitch) {
        int ballCount = 0;
        for (int answerOrder = 0; answerOrder < GAME_NUMBER_LENGTH; answerOrder++) {
            ballCount += isBall(pitch.get(answerOrder), answerOrder);
        }
        return ballCount;
    }

    private int isBall(Integer pitch, int answerOrder) {
        int pitchIndexAnswerContains = answer.indexOf(pitch);
        if ((pitchIndexAnswerContains < 0) || (pitchIndexAnswerContains == answerOrder)) {
            return NOT_MATCH;
        }
        return MATCH;
    }

    private int getStrikeCount(List<Integer> pitch) {
        int strikeCount = 0;
        for (int answerOrder = 0; answerOrder < GAME_NUMBER_LENGTH; answerOrder++) {
            strikeCount += isStrike(answer.get(answerOrder), pitch.get(answerOrder));
        }
        return strikeCount;
    }

    private int isStrike(Integer answer, Integer pitch) {
        if (answer.equals(pitch)) {
            return MATCH;
        }
        return NOT_MATCH;
    }
}
