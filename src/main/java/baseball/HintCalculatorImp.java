package baseball;

import java.util.HashMap;

public class HintCalculatorImp implements HintCalculator {

    @Override
    public Hint getHint(int answer, int userInput) {
        int strike = 0;
        int ball = 0;
        HashMap<Integer, Integer> answerMap = new HashMap<>();
        HashMap<Integer, Integer> userInputMap = new HashMap<>();
        int idx = 0;
        while (answer > 0) {
            answerMap.put(answer % 10, idx++);
            answer /= 10;
        }
        idx = 0;
        while (userInput > 0) {
            userInputMap.put(userInput % 10, idx++);
            userInput /= 10;
        }
        for (Integer key : answerMap.keySet()) {
            if (userInputMap.get(key) != null) {
                if (userInputMap.get(key) == answerMap.get(key)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return Hint.builder().strike(strike).ball(ball).build();
    }
}
