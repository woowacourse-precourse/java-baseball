package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparison {
    private static Integer locate(List<Integer> computerNum, List<Integer> userNum) {
        int sameCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i) == userNum.get(i)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    private static Integer contain(List<Integer> computerNum, List<Integer> userNum) {
        int containCount = 0;
        for (Integer num : userNum) {
            if (computerNum.contains(num)) {
                containCount++;
            }
        }
        return containCount;
    }

    public static List<Integer> compare(List<Integer> computerNum, List<Integer> userNum) {
        List<Integer> result = new ArrayList<>();
        int strike = locate(computerNum, userNum);
        int ball = contain(computerNum, userNum) - strike;
        result.add(strike);
        result.add(ball);
        return result;
    }
}
