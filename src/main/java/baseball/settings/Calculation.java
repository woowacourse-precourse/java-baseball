package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public static List<Integer> getScoresByNumbers(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        int ballCount = INITIAL_COUNT;
        int strikeCount = INITIAL_COUNT;
        List<Integer> scores = new ArrayList<>();

        for (int index = 0; index < playerNumbers.size(); index++) {
            if (playerNumbers.get(index) == dealerNumbers.get(index)) {
                strikeCount++;
                continue;
            }
            if (dealerNumbers.contains(playerNumbers.get(index))) {
                ballCount++;
            }
        }
        scores.addAll(List.of(ballCount, strikeCount));
        return scores;
    }
}
