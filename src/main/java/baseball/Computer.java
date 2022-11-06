package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> setRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < CNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (isNumberInList(randomNumber, randomNumberList))
                randomNumberList.add(randomNumber);
        }
        return randomNumberList;
    }

    private boolean isNumberInList(int number, List<Integer> numberList) {
        if (numberList.contains(number))
            return false;
        return true;
    }
}
