package baseball.engine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballEngine {

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public List<Integer> parseInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();

        for (char input : userInput.toCharArray()) {
            int convertedToIntValue = Character.getNumericValue(input);
            userInputList.add(convertedToIntValue);
        }

        return userInputList;
    }

}
