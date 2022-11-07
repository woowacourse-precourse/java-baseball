package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumbersList;

    public Computer() {
        this.computerNumbersList = setComputerNumbersByList();
    }

    public List<Integer> getComputerNumbersList() {
        return this.computerNumbersList;
    }

    private List<Integer> setComputerNumbersByList() {
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
