package baseball;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BallNumbers {
    private static final int MAX = 3;
    private final List<BallNumber> ballNumbers;

    public BallNumbers(List<Character> hits) {
        checkHits(hits);
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

    private static void checkHits(List<Character> hits) {
        checkMax(hits);
        checkDuplicate(hits);
    }

    private static void checkMax(List<Character> hits) {
        if (hits.size() > MAX) {
            throw new BallInputException("세자리 이상의 수는 입력할 수 없습니다.");
        }
    }

    private static void checkDuplicate(List<Character> hits) {
        if (hits.stream().anyMatch(ballNum -> Collections.frequency(hits, ballNum) > 1)) {
            throw new BallInputException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public int size() {
        return ballNumbers.size();
    }
}
