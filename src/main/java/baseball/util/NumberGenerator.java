package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private List<Integer> computer = new ArrayList<>();

    public List<Integer> generateNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNum(computer, randomNumber);
        }
        return computer;
    }

    private void addNum(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
