package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerHoldNumbers = new ArrayList<>();

    public List<Integer> getComputerHoldNumbers() {
        return computerHoldNumbers;
    }

    public void generateRandomNumber() {
        while (computerHoldNumbers.size() != 3) {
            int generatedNumber = Randoms.pickNumberInRange(1, 9);
            if (computerHoldNumbers.contains(generatedNumber)) {
                continue;
            }
            computerHoldNumbers.add(generatedNumber);
        }
    }
}
