package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private final List<Integer> computerNumber;

    public Computer() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
