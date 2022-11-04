
package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    // 볼 스트라이크 알려주기
    private boolean[] usedNumber = new boolean[9];

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> makeRandomValues() {
        for (int index = 0; index < 3; index++) {
            int picked = Randoms.pickNumberInRange(1, 9);
            if (checkDuplicate(picked)) {
                numbers.add(picked);
            } else {
                index--;
            }
        }
        return numbers;
    }

    private boolean checkDuplicate(int number) {
        if (!usedNumber[number - 1]) {
            usedNumber[number - 1] = true;
            return true;
        } else {
            return false;
        }
    }
}
