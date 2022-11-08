package baseball.controller;

import java.util.HashMap;

public class BaseballResult {
    private static final int ANSWER_COUNT = 3;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private HashMap<String, Integer> result;

    public BaseballResult (HashMap<String, Integer> result) {
        this.result = result;
    }

    public String getResult() {
        if(result.isEmpty()) {
            return NOTHING;
        }
        return  ballAndStrike();
    }

    private String ballAndStrike() {
        if(!result.containsKey(STRIKE)) {
            return result.get(BALL) + "볼";
        }else if(result.get(STRIKE) == ANSWER_COUNT) {
            return result.get(STRIKE) + "스트라이크";
        }else {
            String ball = result.get(BALL) + "볼";
            String strike = result.get(STRIKE) + "스트라이크";
            return  ball + ' ' + strike;
        }
    }
    public boolean isALLCorrect() {
        return result.containsKey(STRIKE) && result.get(STRIKE) == ANSWER_COUNT;
    }

}
