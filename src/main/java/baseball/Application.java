package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int NUM_OF_DIGIT = 3;
    public static final int DIGIT_MIN = 1;
    public static final int DIGIT_MAX = 9;

    public static List<Integer> computerNumList = new ArrayList<>();
    public static List<Integer> userNumList = new ArrayList<>();

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

    private static void userInputThreeDigitNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNum = Console.readLine();
        userNumList = splitStringAndParseInt(userInputNum);
    }

    private static List<Integer> splitStringAndParseInt(String userInputNum) {
        List<Integer> ret = new ArrayList<>();
        String[] splitUserInputNum = userInputNum.split("");

        for (String s : splitUserInputNum) {
            ret.add(Integer.parseInt(s));
        }

        return ret;
    }

}
