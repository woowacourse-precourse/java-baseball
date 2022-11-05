package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StrikeAndBallCount {
    private static final String NBSP = " ";
    private static final int ALREADY_CHECKED_IN_TARGET = -1;
    private static final int ALREADY_CHECKED_IN_GUESS = -2;

    private int strikeCount;
    private int ballCount;

    private final int digitNumber;

    public StrikeAndBallCount(List<Integer> target, List<Integer> guessValue) {
        List<Integer> copyTarget = new ArrayList<>(target);
        List<Integer> copyGuessValue = new ArrayList<>(guessValue);
        digitNumber = target.size();
        setStrikeCountAndCheckIfStrike(copyTarget, copyGuessValue);
        setBallCount(copyTarget, copyGuessValue);
    }

    //스트라이크 수를 파악 후, 만약 스트라이크면 해당 요소에 체크 진행(이후 볼 카운트시 이중으로 카운트 방지)
    private void setStrikeCountAndCheckIfStrike(List<Integer> target, List<Integer> guessValue) {
        for (int i = 0; i < digitNumber; i++) {
            if (Objects.equals(target.get(i), guessValue.get(i))) {
                strikeCount++;
                guessValue.set(i, ALREADY_CHECKED_IN_GUESS);
                target.set(i, ALREADY_CHECKED_IN_TARGET);
            }
        }
    }

    private void setBallCount(List<Integer> target, List<Integer> guessValue) {
        guessValue.forEach(element -> {
            if (target.contains(element)) {
                ballCount++;
            }
        });
    }

    public boolean isOut() {
        return strikeCount == digitNumber;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return BallCountMessage.NOTHING_KO.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        toStringBallCount(stringBuilder);
        toStringStrikeCount(stringBuilder);
        return stringBuilder.toString();
    }

    private void toStringStrikeCount(StringBuilder stringBuilder) {
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount);
            stringBuilder.append(BallCountMessage.STRIKE_KO);
        }
    }

    private void toStringBallCount(StringBuilder stringBuilder) {
        if (ballCount > 0) {
            stringBuilder.append(ballCount);
            stringBuilder.append(BallCountMessage.BALL_KO);
            stringBuilder.append(NBSP);
        }
    }

    private boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
