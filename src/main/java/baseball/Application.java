package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int NUM_OF_DIGIT = 3;
    public static final int DIGIT_MIN = 1;
    public static final int DIGIT_MAX = 9;

    public static List<Integer> computerNumList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void computerRandomThreeDigitNum() {
        while (computerNumList.size() < NUM_OF_DIGIT) {
            int randomDigit = Randoms.pickNumberInRange(DIGIT_MIN, DIGIT_MAX);

            if (computerNumList.contains(randomDigit) == false) {
                computerNumList.add(randomDigit);
            }
        }
    }

}
