package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandNumber {
    public List<Integer> arrayNum() {
        List<Integer> correct = new ArrayList<>();

        while (correct.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!correct.contains(randNumber)) {
                correct.add(randNumber);
            }
        }
        return correct;
    }

}
