package baseball.uitls;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int NUMBER_SIZE = 3;
    private static final int RANDOM_NUMBER_START = 1;
    private static final int RANDOM_NUMBER_END = 9;
    public static int makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        StringBuffer randomNumber = convertListToStringBuffer(randomNumberList);
        return Integer.parseInt(randomNumber.toString());
    }

    private static StringBuffer convertListToStringBuffer(List<Integer> randomNumberList) {
        StringBuffer randomNumber = new StringBuffer();
        for (Integer i : randomNumberList) {
            randomNumber.append(i);
        }
        return randomNumber;
    }
}
