package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 9;
    private static final int LIMIT_SIZE = 3;

    public static List<Integer> getRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < LIMIT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_VALUE, END_VALUE);
            if (isUnique(randomNumberList, randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    private static boolean isUnique(List<Integer> randomNumberList, int randomNumber) {
        return !randomNumberList.contains(randomNumber);
    }
}
