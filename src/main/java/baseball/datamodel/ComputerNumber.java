package baseball.datamodel;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> numbers = new ArrayList<>();
    public ComputerNumber() {}
    public void makeNumber() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
