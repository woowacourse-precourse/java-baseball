package baseball;

import java.util.Objects;

public class StrikeAndBallCount {
    private static final String NBSP = " ";

    private int strikeCount;
    private int ballCount;

    public StrikeAndBallCount(Target target, BallCountGuess ballCountGuess) {
        setStrikeCountAndCheckIfStrike(target, ballCountGuess);
        setBallCount(target, ballCountGuess);
    }

    //스트라이크 수를 파악 후, 만약 스트라이크면 해당 요소에 체크 진행(이후 볼 카운트시 이중으로 카운트 방지)
    private void setStrikeCountAndCheckIfStrike(Target target, BallCountGuess ballCountGuess) {
        for (int i = 0; i < GamePlayer.DIGIT_NUMBER; i++) {
            if (Objects.equals(target.get(i), ballCountGuess.get(i))) {
                strikeCount++;
                target.check(i);
                ballCountGuess.check(i);
            }
        }
    }

    private void setBallCount(Target target, BallCountGuess ballCountGuess) {
        ballCountGuess.getAll().forEach(element -> {
            if (target.isContain(element)) {
                ballCount++;
            }
        });
    }

    public boolean isOut() {
        return strikeCount == GamePlayer.DIGIT_NUMBER;
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
