package baseball;

import java.util.List;

public class PlayerNumber {
    private static final int BALL_NUMBER_SET_SIZE = 3;
    private static final String BALL_NUMBER_SET_OUT_OF_RANGE = "야구공 숫자는 3개까지 입력할 수 있습니다.";
    private final List<BallNumber> playerNumberSet;

    public PlayerNumber(List<BallNumber> ballNumberSet) {
        validateBallNumberSetSize(ballNumberSet);
        this.playerNumberSet = ballNumberSet;
    }

    private void validateBallNumberSetSize(List<BallNumber> ballNumberSet) {
        if (ballNumberSet.size() != BALL_NUMBER_SET_SIZE) {
            throw new IllegalArgumentException(BALL_NUMBER_SET_OUT_OF_RANGE);
        }
    }

    public List<BallNumber> getPlayerNumberSet() {
        return playerNumberSet;
    }
}