package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Player {
    private static final int NUMBER_LENGTH = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    private ArrayList<Integer> number = new ArrayList<Integer>(NUMBER_LENGTH);

    public void setRandomNumber() {
        while (number.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}
