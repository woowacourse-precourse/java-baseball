package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private User user;
    private static String[] compareResult;

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

    public String[] compareNumber() {
        compareResult = new String[3];
        List<Integer> computerNumbers = createRandomNumber();
        List<Integer> userNumbers = user.createUserNumber();
        return compareResult;
    }

    public void inputCompareResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (isSameIndexOfSameNumber(computerNumbers, userNumbers, userNumber)) {
                compareResult[i] = "스트라이크";
                continue;
            }
            if (isContainsNumber(computerNumbers, userNumber)) {
                compareResult[i] = "볼";
                continue;
            }
            compareResult[i] = "낫싱";
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
}