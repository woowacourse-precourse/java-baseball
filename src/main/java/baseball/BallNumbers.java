package baseball;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BallNumbers {
    private final List<BallNumber> ballNumbers;


    public BallNumbers(List<Character> hits) {
        this.ballNumbers = ballNumbers(hits);
    }

    public int roundResult(int round, BallNumber roundBall) {
        if (strike(round, roundBall)) {
            return 0;
        }
        if (ball(round, roundBall)) {
            return 1;
        }

        return -1;
    }

    private boolean strike(int round, BallNumber roundBall) {
        return roundNumber(round).equals(roundBall);
    }

    private boolean ball(int round, BallNumber roundBall) {
        return ballNumbers.contains(roundBall) && roundNumber(round) != roundBall;
    }

    public BallNumber roundNumber(int round) {
        return ballNumbers.get(round);
    }

    private static List<BallNumber> ballNumbers(List<Character> hits) {
        return hits.stream()
                .map(BallNumber::ballNumber)
                .collect(Collectors.toList());
    }

    public int size() {
        return ballNumbers.size();
    }
}
