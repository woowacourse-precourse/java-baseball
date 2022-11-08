package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    public List<Integer> randomNumberList;

    static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }

    private boolean IsInList(int number) {
        return randomNumberList.contains(number);
    }

    private void addToRandomNumberList() {
        while (true) {
            int number = getRandomNumber();
            if (!IsInList(number)) {
                randomNumberList.add(number);
                break;
            }
        }
    }

    public void generate() {
        randomNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            addToRandomNumberList();
        }
    }

    public int getRandomNumberAt(int index) {
        return randomNumberList.get(index);
    }
}
