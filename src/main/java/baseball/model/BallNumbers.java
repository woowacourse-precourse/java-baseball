package baseball.model;

import baseball.BallInputException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BallNumbers {
    private static final int MAX = 3;
    private static final char Zero = '0';
    private final List<BallNumber> ballNumbers;


    public BallNumbers(List<Character> hits) {
        checkHits(hits);
        this.ballNumbers = ballNumbers(hits);
    }

    private void checkHits(List<Character> hits) {
        checkDuplicate(hits);
        checkMax(hits);
        checkZero(hits);
    }

    public int roundResult(int round, BallNumber roundBall) {
        if (strike(round, roundBall)) {
            return MAX;
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
        return this.ballNumbers.contains(roundBall) && roundNumber(round) != roundBall;
    }

    public BallNumber roundNumber(int round) {
        return ballNumbers.get(round);
    }

    private List<BallNumber> ballNumbers(List<Character> hits) {
        return hits.stream()
                .map(BallNumber::new)
                .collect(Collectors.toList());
    }

    private void checkMax(List<Character> hits) {
        if (hits.size() > MAX) {
            throw new BallInputException("세 자리 이상 입력받을 수 없습니다.");
        }
    }

    private void checkZero(List<Character> hits) {
        if (hits.contains(Zero)) {
            throw new BallInputException("0은 입력할 수 없습니다.");
        }
    }


    private void checkDuplicate(List<Character> hits) {
        if (hits.stream().anyMatch(ballNum -> Collections.frequency(hits, ballNum) > 1)) {
            throw new BallInputException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public int size() {
        return ballNumbers.size();
    }
}
