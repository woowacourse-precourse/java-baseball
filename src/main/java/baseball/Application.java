package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> pickUniqueNumbersInRange(
            int startInclusive,
            int endInclusive,
            int range
    ) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < range) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            saveUniqueNumber(uniqueNumbers, randomNumber);
        }

        return uniqueNumbers;
    }

    public static void saveUniqueNumber(List<Integer> uniqueNumbers, int randomNumber) {
        if (isExistNumber(uniqueNumbers, randomNumber)) {
            return;
        }
        uniqueNumbers.add(randomNumber);
    }

    public static boolean isExistNumber(List<Integer> uniqueNumbers, int randomNumber) {
        if (uniqueNumbers.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
