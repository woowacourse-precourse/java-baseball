package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        createComputerNumbers();
    }

    private void createComputerNumbers() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return Collections.unmodifiableList(computerNumber);
    }
}
