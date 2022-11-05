package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public static List<Integer> getScoresBy(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        int ballCount = INITIAL_COUNT;
        int strikeCount = INITIAL_COUNT;

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i) == dealerNumbers.get(i)) {
                strikeCount++;
                continue;
            }
            if (dealerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }
        scores.addAll(List.of(ballCount, strikeCount));
        return scores;
    }
}
