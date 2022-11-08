package baseball;

import java.util.List;

public class PlayerNumber {
    private final List<BallNumber> playerNumberSet;

    public PlayerNumber(List<BallNumber> ballNumberSet) {
        validateBallNumberSetSize(ballNumberSet);
        this.playerNumberSet = ballNumberSet;
    }

    private void validateBallNumberSetSize(List<BallNumber> ballNumberSet) {
        if (ballNumberSet.size() != MessageUtils.BALL_SET_SIZE) {
            throw new IllegalArgumentException(MessageUtils.NUMBER_SIZE_OUT_OF_RANGE_MESSAGE);
        }
    }

    public List<BallNumber> getPlayerNumberSet() {
        return playerNumberSet;
    }
}