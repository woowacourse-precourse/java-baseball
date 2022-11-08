package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public void initHint() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isStrike(List<Integer> computerNumber, int userNumber, int index) {
        if (computerNumber.get(index) == userNumber) {
            return true;
        }
        return false;
    }

}
