package baseball.service;

import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberListGenerator {

    public List<Integer> generate(){
        System.out.println(Randoms.pickUniqueNumbersInRange(1, 9, 3));
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
