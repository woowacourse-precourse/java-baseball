package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public static List<Integer> createBaseBall() {
        List<Integer> baseBallNumber = new ArrayList<>();
        while (baseBallNumber.size() < 3) {
            int digit = Randoms.pickNumberInRange(0, 9);
            if (baseBallNumber.contains(digit)) {
                continue;
            }
            baseBallNumber.add(digit);
        }
        return baseBallNumber;
    }
}
