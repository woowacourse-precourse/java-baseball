package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Valid.validNumberList;

public class Computer {
    private List<Integer> randomNumber;
    private static final boolean INVALID = false;

    public void init() {
        do {
            makeRandomList();
        }
        while (validNumberList(randomNumber) == INVALID);
    }

    public void makeRandomList() {
        randomNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
    }
}
