package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<Integer> getScoresByNumbers(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = INITIAL_COUNT;
        int strikeCount = INITIAL_COUNT;
        List<Integer> scores = new ArrayList<>();

        for (int index = 0; index < userNumber.size(); index++) {
            if (userNumber.get(index) == computerNumber.get(index)) {
                strikeCount++;
                continue;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                ballCount++;
            }
        }
        scores.addAll(List.of(ballCount, strikeCount));
        return scores;
    }
}
