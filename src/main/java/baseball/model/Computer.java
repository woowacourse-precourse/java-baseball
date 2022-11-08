package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
        generateNumbers();
    }

    private void generateNumbers() {
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (numbers.contains(number)) {
                continue;
            }
            numbers.add(number);
        }
    }

    public final List<Integer> getNumbers() {
        return numbers;
    }
}