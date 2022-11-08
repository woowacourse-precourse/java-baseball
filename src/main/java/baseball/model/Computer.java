package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int COUNT_NUMBER = 3;

    public static List<Integer> computerSelectNumbers() {
        List<Integer> SelectedNumber = new ArrayList<>();
        while (SelectedNumber.size() < COUNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!SelectedNumber.contains(randomNumber)) {
                SelectedNumber.add(randomNumber);
            }
        }
        return SelectedNumber;
    }
}
