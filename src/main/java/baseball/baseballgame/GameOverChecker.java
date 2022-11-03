package baseball.baseballgame;

import java.util.List;

public class GameOverChecker {

    public static boolean check(List<Integer> report) {
        return report.get(0) == 3;
    }
}
