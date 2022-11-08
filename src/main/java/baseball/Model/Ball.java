package baseball.Model;

import baseball.Util.Constant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class Ball {
    LinkedHashMap<String, Integer> ballMap = new LinkedHashMap<>();
    String[] ballArr = {Constant.HINT_BALL, Constant.HINT_STRIKE, Constant.HINT_NOTHING};


    public String ballHintResult(String userInput, String computerInput) {
        setBallMap();
        ballHintPush(userInput, computerInput);
        return returnHint();
    }

    public void setBallMap() {
        for (String ball : ballArr) {
            ballMap.put(ball, 0);
        }
    }

    public void ballHintPush(String userInput, String computerInput) {
        for (int i = 0; i < Constant.MAX_LENGTH; i++) {
            int condition = computerInput.indexOf(userInput.charAt(i));
            if (condition == i) {
                ballMap.put(ballArr[1], ballMap.get(ballArr[1]) + 1);
                continue;
            }
            if (condition == -1) {
                ballMap.put(ballArr[2], ballMap.get(ballArr[2]) + 1);
                continue;
            }
            ballMap.put(ballArr[0], ballMap.get(ballArr[0]) + 1);
        }
    }

    public String returnHint() {
        List<String> resultArr = new ArrayList<>();
        if (ballMap.get(ballArr[2]) > 2) {
            resultArr.add(ballArr[2]);
            return String.join(" ", resultArr);
        }
        for (String hint : ballMap.keySet()) {
            if (ballMap.get(hint) < 1) {
                continue;
            }
            if (!Objects.equals(hint, ballArr[2])) {
                resultArr.add(ballMap.get(hint) + hint);
            }
        }
        return String.join(" ", resultArr);
    }
}
