package baseball;

public class ReplayNumber {

    private int replayNumber;

    public ReplayNumber(int input) {
        validateRange(input);
        this.replayNumber = input;
    }

    private void validateRange(int input) {
        if ((input != 1) && (input != 2)) {
            throw new IllegalArgumentException("0 혹은 1만 입력할 수 있습니다.");
        }
    }

    public boolean isReplay() {
        return (replayNumber == 1);
    }

}
