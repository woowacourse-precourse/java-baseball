package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> makeComputerRandomNumber() {
        List<Integer> numArr = new ArrayList<Integer>();

        while (numArr.size() < 3) {
            pickRandomNumber(numArr);
        }

        return numArr;
    }

    public static List<Integer> pickRandomNumber(List<Integer> numArr) {
        int number = Randoms.pickNumberInRange(1, 9);

        if (!numArr.contains(number)) {
            numArr.add(number);
        }

        return numArr;
    }
}
