package member;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers() {

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public void clearNumbers() {
        numbers.clear();
    }
}
