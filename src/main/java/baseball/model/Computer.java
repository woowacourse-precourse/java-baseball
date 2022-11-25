package baseball.model;

import static baseball.util.NumberValidator.validateDuplicates;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = createComputerNumber();
    }

    private List<Integer> createComputerNumber() {
        validateDuplicates(generateComputerNumber());
        return computerNumber;
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }




    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
