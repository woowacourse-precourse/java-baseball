package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<Integer> setAnswerNum() {
        List<Integer> numList = new ArrayList<>();
        while(numList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!numList.contains(num)) {
                numList.add(num);
            }
        }
        return numList;
    }
}
