package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> generate() {
        while (!hasThreeNumbers(numbers)) {
            int random = pickNumberInRange(1, 9);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }

    private void initialize() {
        numbers.clear();
    }

    private boolean hasThreeNumbers(List<Integer> numbers) {
        return numbers.size() == 3;
    }
}

