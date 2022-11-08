package baseball;

import java.util.List;
import java.util.Map;

import static baseball.Score.BALL;
import static baseball.Score.STRIKE;

public class CompareNumber {
    public static void compare(List<String> computerNumber, List<String> userInput, Map<Score, Integer> score) {
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(computerNumber.get(i))) {
                score.put(STRIKE, score.get(STRIKE) + 1);
            } else if (computerNumber.contains(userInput.get(i))) {
                score.put(BALL, score.get(BALL) + 1);
            }
        }
    }
}
