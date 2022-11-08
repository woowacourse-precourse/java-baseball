package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorUtil {

    private RandomGeneratorUtil() {
    }

    public static List<Integer> generateDistinctThreeRandomNumber(){

        List<Integer> numberDistinctDigitList = new ArrayList<>();
        while (numberDistinctDigitList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberDistinctDigitList.contains(randomNumber)) {
                numberDistinctDigitList.add(randomNumber);
            }
        }

        return numberDistinctDigitList;
    }


}
