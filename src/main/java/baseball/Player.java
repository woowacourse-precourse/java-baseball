package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> getComputerRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicateNumber(computer, randomNumber);
        }

        return computer;
    }

    private void checkDuplicateNumber(List<Integer> computer, Integer randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
