package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private List<Integer> computerNumber;

    public void setComputerNumber() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }
        this.computerNumber = new ArrayList<>(randomNumbers);
    }

    public List<Integer> getComputerNumber() {
        return this.computerNumber;
    }
}
