package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResultJudgement {

    private int maxLen;

    public GameResultJudgement(int maxLen) {
        this.maxLen = maxLen;
    }

    public List<Integer> judgeStrikeBallNothing(String str1, String str2) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for (int i = 0; i < maxLen; i++) {
            char ch = str2.charAt(i);
            boolean isOverlap = str1.charAt(i) == str2.charAt(i);
            if (!isOverlap && str1.contains(ch + "")) {
                ++ball;
            } else if (isOverlap) {
                ++strike;
            }
        }
        if (strike == 0 && ball == 0) {
            ++nothing;
        }
        return new ArrayList<>(Arrays.asList(strike, ball, nothing));
    }
}
