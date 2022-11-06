package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResultJudgement {

    private int maxLen;

    public GameResultJudgement() {
        this(3);
    }

    public GameResultJudgement(int maxLen) {
        this.maxLen = maxLen;
    }

    public List<Integer> judgeStrikeBallNothing(String str1, String str2) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for (int i = 0; i < maxLen; i++) {
            char ch = str2.charAt(i);
            if (!(str1.charAt(i) == str2.charAt(i)) && str1.contains(ch + "")) {
                ++ball;
            } else if (str1.charAt(i) == str2.charAt(i)) {
                ++strike;
            }
        }
        if (strike == 0 && ball == 0) {
            ++nothing;
        }
        return new ArrayList<>(Arrays.asList(strike, ball, nothing));
    }
}
