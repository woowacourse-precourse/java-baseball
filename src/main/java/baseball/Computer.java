package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = randomNumberGenerator();
    }

    private List<Integer> randomNumberGenerator() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
