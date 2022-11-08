package baseball;

import java.util.HashMap;
import java.util.List;

class Compare {
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";

    static HashMap<String, Integer> compareWithAnswer(List<Character> answerList,
                                                      List<Character> userInputList) {
        HashMap<String, Integer> comparedMap = new HashMap<>();
        comparedMap.put(BALL, 0);
        comparedMap.put(STRIKE, 0);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            char answer = answerList.get(comparingNum);
            char input = userInputList.get(comparingNum);
            if (answerList.contains(input)) {
                computeBallStrike(comparedMap, answer, input);
            }
        }
        return comparedMap;
    }

    static void computeBallStrike(HashMap<String, Integer> comparedMap,
                                  char answer, char input) {
        if (answer == input) {
            Utils.addOneToMap(comparedMap, STRIKE);
        } else {
            Utils.addOneToMap(comparedMap, BALL);
        }
    }

    static boolean inputEqualsAnswer(HashMap<String, Integer> comparedMap) {
        return comparedMap.get(STRIKE) == 3;
    }
}
