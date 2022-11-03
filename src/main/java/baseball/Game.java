package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int _strike = 0;
    private static final int _ball = 1;

    public int scanUserValue() {
        return -1;
    }

    public List<Integer> calcRoundResult(int userValue, int opponentValue) {
        List<Integer> ret = new ArrayList<>();

        return ret;
    }

    public int printHint(List<Integer> roundResult) {
        return 1;
    }

    public boolean scanIsEnd() {
        return true;
    }
}
