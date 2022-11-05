package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumber {

    private static List<Integer> computerNumber;

    public ComputerRandomNumber() {
        this.computerNumber = computerRandomNumber();
    }

    private List<Integer> computerRandomNumber() {
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }
    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
