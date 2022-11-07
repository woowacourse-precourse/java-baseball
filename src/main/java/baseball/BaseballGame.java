package baseball;

import java.util.List;

public class BaseballGame {

    static int strikeCheck(List<Integer> cut, List<Integer> computer) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (cut.get(i) == computer.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static int ballCheck(List<Integer> cut, List<Integer> computer) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if ((cut.get(i) != computer.get(i)) && computer.contains(cut.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean notingCheck(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

}
