package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int COMPUTER_LIST_MAX_THREE = 3;
    private static final int RANDOM_NUMBER_MINIMUM_ONE = 1;
    private static final int RANDOM_NUMBER_MAXIMUM_NINE = 9;

    public static List<Long> makeRandomNumber() {
        List<Long> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_LIST_MAX_THREE) {
            long randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM_ONE, RANDOM_NUMBER_MAXIMUM_NINE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
