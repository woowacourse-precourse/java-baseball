package baseball.domain;

import baseball.exception.CheckIntegerLengthException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class VerifyBaseballNumbers {
    private static List<BaseballNumber> userBaseballNumber;

    public VerifyBaseballNumbers(String userNumbers) {

    }

    private List<BaseballNumber> convertBaseBallNumberFormat(String userNumbers) {
        List<BaseballNumber> userNumbersList = new ArrayList<>();
        for (int i = 0; i < userNumbers.length(); i++) {
            userNumbersList.add(new BaseballNumber(userNumbers.charAt(i)));
        }
        return userNumbersList;
    }

    private void validateUserNumbers(String userNumbers) {
        if (userNumbers.length() != 3) {
            throw new CheckIntegerLengthException();
        }
    }

    public int calculateBallCount(List<BaseballNumber> randomNumbers) {
        return (int) IntStream.rangeClosed(0, 2).filter(i -> isBall(i, randomNumbers)).count();
    }

    private boolean isBall(int targetIndex, List<BaseballNumber> randomNumbers) {
        BaseballNumber randomBaseBallNumber = randomNumbers.get(targetIndex);
        BaseballNumber userBaseBallNumber = userBaseballNumber.get(targetIndex);
        return !randomBaseBallNumber.equals(userBaseBallNumber) && contains(randomBaseBallNumber);
    }

    public int calculateStrikeCount(List<BaseballNumber> randomNumbers) {
        return (int) IntStream.rangeClosed(0, 2).filter(i -> isStrike(i, randomNumbers)).count();
    }

    private boolean isStrike(int targetIndex, List<BaseballNumber> randomNumbers) {
        BaseballNumber randomBaseBallNumber = randomNumbers.get(targetIndex);
        BaseballNumber userBaseBallNumber = userBaseballNumber.get(targetIndex);
        return randomBaseBallNumber.equals(userBaseBallNumber);
    }

    public boolean contains(BaseballNumber compareBaseBallNumber) {
        return userBaseballNumber.stream()
                .anyMatch(baseBallNumber -> baseBallNumber.equals(compareBaseBallNumber));
    }
}
