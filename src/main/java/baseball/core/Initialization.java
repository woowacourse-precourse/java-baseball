package baseball.core;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Initialization {

    // 정답 숫자 생성 (서로 다른 3개의 숫자)
    public static String createTargetNumber() {
        List<Integer> listOfDigits = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        StringBuilder targetNumber = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int digit = Randoms.pickNumberInList(listOfDigits);
            listOfDigits.remove(digit);
            targetNumber.append(digit);
        }
        return targetNumber.toString();
    }
}
