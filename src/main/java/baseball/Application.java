package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    }

    private static String getRandomThreeDigitNumberString() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder threeDigitNumberStringBuilder = new StringBuilder();

        for (Integer digitNumber : computer) {
            threeDigitNumberStringBuilder.append(digitNumber);
        }

        return String.valueOf(threeDigitNumberStringBuilder);
    }
}
