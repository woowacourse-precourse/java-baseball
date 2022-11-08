package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public static List<Integer> setRandomNumber() {
        final int NUMBER_LIST_SIZE = 3;
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 9;
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < NUMBER_LIST_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            RandomNumber.addUniqueNumber(randomNumberList, randomNumber);
        }
        return randomNumberList;
    }

    private static void addUniqueNumber(List<Integer> numberList, int number) {
        if (!numberList.contains(number)) {
            numberList.add(number);
        }
    }
}
