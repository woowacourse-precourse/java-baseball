package baseball.service;

import static baseball.type.NumberType.MAXIMUM_NUMBER;
import static baseball.type.NumberType.MINIMUM_NUMBER;
import static baseball.type.NumberType.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberService {

    public static List<Integer> generate() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (!hasThreeNumbers(computerNumbers)) {
            int random = pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);

            if (!computerNumbers.contains(random)) {
                computerNumbers.add(random);
            }
        }
        return computerNumbers;
    }

    private static boolean hasThreeNumbers(List<Integer> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

}
