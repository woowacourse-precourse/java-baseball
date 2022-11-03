package baseball.number;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Constant.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNumber {
    public NumberDto generate() {
        return new NumberDto(pickRandomNumber());
    }

    public NumberDto generate(NumberDto numberDto) {
        numberDto.setNumber(pickRandomNumber());
        return numberDto;
    }

    private List<Integer> pickRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
