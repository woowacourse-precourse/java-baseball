package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private String[] compareResult;
    private int ballCount;
    private int strikeCount;
    private int nothingCount;

    public List<Integer> createRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public void createCompareResult() {
        User user = new User();
        compareResult = new String[3];
        List<Integer> computerNumbers = createRandomNumber();
        List<Integer> userNumbers = user.createUserNumber();
        inputCompareResult(computerNumbers, userNumbers);
    }

    public void inputCompareResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (isSameIndexOfSameNumber(computerNumbers, userNumbers, userNumber)) {
                compareResult[i] = STRIKE;
                continue;
            }
            if (isContainsNumber(computerNumbers, userNumber)) {
                compareResult[i] = BALL;
                continue;
            }
            compareResult[i] = NOTHING;
        }
    }

    public boolean isContainsNumber(List<Integer> computerNumbers, int number) {
        if (computerNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isSameIndexOfSameNumber(List<Integer> computerNumbers, List<Integer> userNumbers, int number) {
        if (isContainsNumber(computerNumbers, number)) {
            int computerNumberIndex = computerNumbers.indexOf(number);
            int userNumberIndex = userNumbers.indexOf(number);
            if (computerNumberIndex == userNumberIndex) {
                return true;
            }
        }
        return false;
    }

    public void compareGameScore() {
        createCompareResult();
        for (int i = 0; i < compareResult.length; i++) {
            if (compareResult[i] == STRIKE) {
                strikeCount++;
            }
            if (compareResult[i] == BALL) {
                ballCount++;
            }
            if (compareResult[i] == NOTHING) {
                nothingCount++;
            }
        }
    }
}