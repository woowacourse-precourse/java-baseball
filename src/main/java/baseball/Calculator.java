package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static int ballCount = INITIAL_COUNT;
    private static int strikeCount = INITIAL_COUNT;

    public static List<Integer> getScoresBy(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        List<Integer> scores = new ArrayList<>();
        countBallAndStrike(dealerNumbers, playerNumbers);
        scores.addAll(List.of(ballCount, strikeCount));
        return scores;
    }

    public static void countBallAndStrike(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i) == dealerNumbers.get(i)) {
                strikeCount++;
                continue;
            }
            if (dealerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }
    }
}
