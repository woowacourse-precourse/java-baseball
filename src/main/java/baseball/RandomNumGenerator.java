package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumGenerator {
    public List<Integer> randomNumGenerator(int size, int start_range, int end_range) {
        List<Integer> random_list = new ArrayList<>();
        while (random_list.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(start_range, end_range);
            if (!random_list.contains(randomNumber)) {
                random_list.add(randomNumber);
            }
        }
        return random_list;
    }
}
