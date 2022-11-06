package baseball;

import java.util.HashMap;
import java.util.Objects;

public class HintCalculatorImp implements HintCalculator {

    @Override
    public Hint getHint(int answer, int userInput) {
        int strike = 0;
        int ball = 0;
        HashMap<Integer, Integer> answerPlaceValueMap = convertToPlaceValueMap(answer);
        HashMap<Integer, Integer> userInputPlaceValueMap = convertToPlaceValueMap(userInput);
        for (Integer key : answerPlaceValueMap.keySet()) {
            if (Objects.equals(answerPlaceValueMap.get(key), userInputPlaceValueMap.get(key))) {
                strike++;
                continue;
            }
            if (userInputPlaceValueMap.get(key) != null) {
                ball++;
            }
        }

        return Hint.builder().strike(strike).ball(ball).build();
    }

    private HashMap<Integer, Integer> convertToPlaceValueMap(int number) {
        int idx = 0;
        HashMap<Integer, Integer> placeValueMap = new HashMap<>();
        while (number > 0) {
            placeValueMap.put(number % 10, idx++);
            number /= 10;
        }
        return placeValueMap;
    }
}
