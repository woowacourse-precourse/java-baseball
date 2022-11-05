package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumber {

    public static final int NUMBER_SIZE = 3;
    private List<Integer> computerNumber;

    public ComputerRandomNumber() {
        computerNumber = new ArrayList<>(NUMBER_SIZE);
    }

    public List<Integer> makeComputerNumber() {
        while (computerNumber.size() < NUMBER_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }
}
