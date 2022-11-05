package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public List<Integer> setRandomNumber() {
        final int NUMBER_LIST_SIZE = 3;
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < NUMBER_LIST_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(randomNumberList, randomNumber);
        }
        return randomNumberList;
    }

    void addUniqueNumber(List<Integer> numberList, int number) {
        if (!numberList.contains(number)) {
            numberList.add(number);
        }
    }
}
