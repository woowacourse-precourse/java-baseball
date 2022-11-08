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

        while (computerNumbers.size() != NUMBER_SIZE.getValue()) {
            int random = pickNumberInRange(MINIMUM_NUMBER.getValue(), MAXIMUM_NUMBER.getValue());

            if (!computerNumbers.contains(random)) {
                computerNumbers.add(random);
            }
        }
        return computerNumbers;
    }
}
