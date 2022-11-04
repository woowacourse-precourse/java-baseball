package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;

    private Computer() {
    }

    public static List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
