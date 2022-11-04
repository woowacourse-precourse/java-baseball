package baseball.service;

import baseball.utils.ConsoleLog;

import java.util.Map;

public class Result {
    private static final boolean CORRECT_ANSWER = true;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String WHITE_SPACE = " ";
    private Result() {
    }

    private static class LazyHolder {
        private static final Result INSTANCE = new Result();
    }

    public static Result getInstance() {
        return Result.LazyHolder.INSTANCE;
    }

    public boolean analysis(Map<String, Integer> score){
        notify(score);
        if (score.get("strike") == 3)
            return CORRECT_ANSWER;
        return !CORRECT_ANSWER;
    }

    private void notify(Map<String, Integer> score) {
        int strike = score.get("strike");
        int ball = score.get("ball");

        String notification = "";
        if (ball > 0)
            notification += ball + BALL + WHITE_SPACE;
        if (strike > 0)
            notification += strike + STRIKE;
        if (ball == 0 && strike == 0)
            notification = NOTHING;
        ConsoleLog.getInstance().println(notification);
    }
}
