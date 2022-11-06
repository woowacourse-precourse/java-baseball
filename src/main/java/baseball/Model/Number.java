package baseball.Model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final int MAX_LEN = 3;

    public List<Integer> createComputerNumber() {
        List<Integer> num = new ArrayList<>();
        while (num.size() < MAX_LEN) {
            int randomNum = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!num.contains(randomNum)) {
                num.add(randomNum);
            }
        }
        return num;
    }
}
