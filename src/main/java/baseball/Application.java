package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> generateThreeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            Integer num = Randoms.pickNumberInRange(1, 9);

            if (computerNumber.contains(num)) {
                i--;
                continue;
            }
            computerNumber.add(num);
        }

        return computerNumber;
    }
}
