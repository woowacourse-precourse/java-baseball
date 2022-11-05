package baseball.service;

import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberListGenerator {

    public static List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
