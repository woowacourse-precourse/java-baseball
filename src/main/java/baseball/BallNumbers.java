package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class BallNumbers {
    private final List<BallNumber> ballNumbers;

    public BallNumbers(List<BallNumber> ballNumbers) {
        ballNumberSizeExceptionCheck(ballNumbers);
        duplicatedNumberExceptionCheck(ballNumbers);
        duplicatedIndexExceptionCheck(ballNumbers);
        this.ballNumbers = ballNumbers;
    }

    public BallStatus compareToBallNumber(BallNumber ballNumber) {
        return this.ballNumbers.stream()
                .map(b -> b.compareToBallNumber(ballNumber))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public GameResult compareToBallNumbers(BallNumbers ballNumbers) {
        GameResult gameResult = new GameResult();
        ballNumbers.ballNumbers
                .forEach(b -> gameResult.report(this.compareToBallNumber(b)));
        return gameResult;
    }

    private void duplicatedIndexExceptionCheck(List<BallNumber> ballNumbers) {
        int notDuplicatedIndexSize = getNotDuplicatedIndexSize(ballNumbers);
        if (notDuplicatedIndexSize != 3) {
            throw new IllegalArgumentException("서로 다른 위치의 3자리의 수를 입력해주세요.");
        }
    }

    private int getNotDuplicatedIndexSize(List<BallNumber> ballNumbers) {
        return ballNumbers.stream()
                .map(BallNumber::getIndex)
                .collect(Collectors.toSet())
                .size();
    }

    private void duplicatedNumberExceptionCheck(List<BallNumber> ballNumbers) {
        int notDuplicatedNumberSize = getNotDuplicatedNumberSize(ballNumbers);
        if (notDuplicatedNumberSize != 3) {
            throw new IllegalArgumentException("서로 다른 임의의 3자리의 수를 입력해주세요.");
        }
    }

    private int getNotDuplicatedNumberSize(List<BallNumber> ballNumbers) {
        return ballNumbers.stream()
                .map(BallNumber::getNumber)
                .collect(Collectors.toSet())
                .size();
    }

    private void ballNumberSizeExceptionCheck(List<BallNumber> ballNumbers) {
        if (ballNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
    }
}
