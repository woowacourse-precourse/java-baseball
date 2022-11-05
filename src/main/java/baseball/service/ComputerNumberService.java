package baseball.service;

import static baseball.type.NumberType.MAXIMUM_NUMBER;
import static baseball.type.NumberType.MINIMUM_NUMBER;
import static baseball.type.NumberType.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberService {
    private static List<Integer> computerNumbers = new ArrayList<>();

    public static List<Integer> generate() {
        initialize();
        while (!hasThreeNumbers(computerNumbers)) {
            int random = pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);

            if (!computerNumbers.contains(random)) {
                computerNumbers.add(random);
            }
        }

        return computerNumbers;
    }

    private static void initialize() {
        computerNumbers.clear();
    }

    private static boolean hasThreeNumbers(List<Integer> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

}
