package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Number {

    static final int FIRST_NUM = 1;
    static final int LAST_NUM = 9;
    static final int MAX_DIGIT = 3;

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNum = new ArrayList<>();

        for (int i = 0; i < MAX_DIGIT; i++) {
            randomNum.add(Randoms.pickNumberInRange(FIRST_NUM, LAST_NUM));
        }

        return randomNum;
    }
}
