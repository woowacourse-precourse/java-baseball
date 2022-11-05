package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomValue {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int MAX_SIZE = 3;

    public List<Integer> getRandom() {
        List<Integer> RandomNum = new ArrayList<>();

        while (RandomNum.size() < MAX_SIZE) {
            int rdNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!RandomNum.contains(rdNum)){
                RandomNum.add(rdNum);
            }
        }

        return RandomNum;
    }
}
