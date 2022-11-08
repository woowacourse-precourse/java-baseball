package baseball;

public class ReplayNumber {

    private static final int REPLAY_YES = 1;
    private static final int REPLAY_NO = 2;

    private int replayNumber;

    public ReplayNumber(int input) {
        validateRange(input);
        this.replayNumber = input;
    }

    private void validateRange(int input) {
        if ((input != REPLAY_YES) && (input != REPLAY_NO)) {
            throw new IllegalArgumentException(Errors.REPLAY_NUMBER_RANGE.getValue());
        }
    }

    public boolean isReplay() {
        return replayNumber == REPLAY_YES;
    }

}
