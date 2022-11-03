package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class NumberController {
    static final int MAX_NUMBER_OF_RANGE = 9;
    static final int MIN_NUMBER_OF_RANGE = 1;
    static final int MAX_NUMBER_OF_DIGIT = 3;

    private NumberController() {
    }

    public static List<Integer> getUniqueThreeNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < MAX_NUMBER_OF_DIGIT) {
            int tempNum = Randoms.pickNumberInRange(MIN_NUMBER_OF_RANGE,MAX_NUMBER_OF_RANGE);

            if (!numberList.contains(tempNum)) {
                numberList.add(tempNum);
            }
        }
        return numberList;
    }

}
