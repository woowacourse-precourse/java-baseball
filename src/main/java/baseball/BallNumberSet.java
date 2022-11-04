package baseball;

import java.util.List;

public class BallNumberSet {
    private static final int BALL_NUMBER_SET_SIZE = 3;
    private static final String BALL_NUMBER_SET_OUT_OF_RANGE = "야구공 숫자는 3개까지 입력할 수 있습니다.";
    private final List<BallNumber> ballNumberSet;

    public BallNumberSet(List<BallNumber> ballNumberSet) {
        validateBallNumberSetSize(ballNumberSet);
        this.ballNumberSet = ballNumberSet;
    }

    private void validateBallNumberSetSize(List<BallNumber> ballNumberSet) {
        if (ballNumberSet.size() != BALL_NUMBER_SET_SIZE) {
            throw new IllegalArgumentException(BALL_NUMBER_SET_OUT_OF_RANGE);
        }
    }
}