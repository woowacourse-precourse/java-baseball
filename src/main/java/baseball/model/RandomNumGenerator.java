package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int LIST_SIZE = 3;

    public List<Integer> getRandomNum() {
        List<Integer> number_list = new ArrayList<>();
        while (number_list.size() < LIST_SIZE) {
            int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!number_list.contains(num)) number_list.add(num);
        }
        return number_list;
    }
}
