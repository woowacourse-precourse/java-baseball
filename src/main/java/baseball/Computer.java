package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> threeDifferntNumber;

    public List<Integer> getThreeDifferntNumber(){
        List<Integer> randomDifferentNumber = new ArrayList<>();

        while (randomDifferentNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomDifferentNumber.contains(number)) {
                randomDifferentNumber.add(number);
            }
        }

        return randomDifferentNumber;
    }
}
