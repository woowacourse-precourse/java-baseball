package baseball;

import static baseball.type.NumberType.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    private static List<Integer> computerNumbers = new ArrayList<>();
    public static List<Integer> generate() {
        while (!hasThreeNumbers(computerNumbers)) {
            int random = pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);

            if (!computerNumbers.contains(random)) {
                computerNumbers.add(random);
            }
        }

        return computerNumbers;
    }

    private void initialize() {
        computerNumbers.clear();
    }

    private static boolean hasThreeNumbers(List<Integer> numbers) {
        return numbers.size() == COMPUTER_NUMBER_SIZE;
    }
}

