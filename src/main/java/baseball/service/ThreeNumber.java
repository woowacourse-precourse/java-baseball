package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ThreeNumber {
    private final List<Integer> number;

    public ThreeNumber() {
        this.number = new ArrayList<>();
    }

    public void generate() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}
