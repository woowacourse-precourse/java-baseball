package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < Constants.NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
