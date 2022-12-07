package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = setComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    private List<Integer> setComputerNumbers() {
        List<Integer> newComputerNumber = new ArrayList<>();
        while (newComputerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber);
            }
        }
        return newComputerNumber;
    }
}
