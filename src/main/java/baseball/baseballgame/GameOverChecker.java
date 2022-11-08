package baseball.baseballgame;

import java.util.List;

public class GameOverChecker {

    public static final int TARGET_COUNT = 3;
    public static final int STRIKE_INDEX = 0;

    public static boolean check(List<Integer> report) {
        return report.get(STRIKE_INDEX) == TARGET_COUNT;
    }
}
