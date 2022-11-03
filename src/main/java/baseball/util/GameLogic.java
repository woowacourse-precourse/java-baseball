package baseball.util;

import baseball.entity.Result;

public class GameLogic {

    public Result judge(String target, String input) {
        Result result = new Result();
        result.setBall(countBall(target, input));
        result.setStrike(countStrike(target, input));
        return result;
    }

    private int countStrike(String target, String input) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private int countBall(String target, String input) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != input.charAt(i) && target.contains(String.valueOf(input.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
}
