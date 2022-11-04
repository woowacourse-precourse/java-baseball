package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            String computerNumber = setComputerNumber();

        } catch (IllegalArgumentException exception) {

        }
    }

    private static String setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return toStringTarget(computerNumber);
    }

    private static String toStringTarget(List<Integer> target) {
        String result="";
        for (Integer num : target) {
            result += num.toString();
        }

        return result;
    }


}
