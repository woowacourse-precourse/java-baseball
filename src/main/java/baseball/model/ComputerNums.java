package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNums {

    private final List<Integer> numbers = new ArrayList<>();

    public ComputerNums(int count) {
        while (numbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
