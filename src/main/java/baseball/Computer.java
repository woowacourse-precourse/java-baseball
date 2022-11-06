package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class Computer {

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
