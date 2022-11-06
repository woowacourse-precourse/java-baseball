package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private static List<Integer> computerNumber;

    public NumberBaseballGame(){
        computerNumber = new ArrayList<>();
    }

    public static void getRandomThreeDigitNumber() {
        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
    }


}
