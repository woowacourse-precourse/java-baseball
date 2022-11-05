package baseball;

import static baseball.type.NumberType.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    private static List<Integer> numbers = new ArrayList<>();

    public static List<Integer> generate() {
        while (!hasThreeNumbers(numbers)) {
            int random = pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }

    private void initialize() {
        numbers.clear();
    }

    private static boolean hasThreeNumbers(List<Integer> numbers) {
        return numbers.size() == COMPUTER_NUMBER_SIZE;
    }
}

