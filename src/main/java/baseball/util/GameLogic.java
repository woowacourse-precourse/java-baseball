package baseball.util;

import baseball.entity.Result;

public class GameLogic {
    private final int STRIKE_COUNT = 3;

    public boolean isGameSet(Result judge) {
        return judge.getStrike() == STRIKE_COUNT;
    }

    public Result judge(String target, String input) {
        Result result = new Result();
        result.setBall(countBall(target, input));
        result.setStrike(countStrike(target, input));
        return result;
    }

    private int countStrike(String target, String input) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (isMatch(target, input, i)) {
                count++;
            }
        }
        return count;
    }

    private int countBall(String target, String input) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (!isMatch(target, input, i) && isContains(target, input, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatch(String target, String input, int i) {
        return target.charAt(i) == input.charAt(i);
    }

    private boolean isContains(String target, String input, int i) {
        return target.contains(String.valueOf(input.charAt(i)));
    }
}
