package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int COMPUTER_SIZE = 3;
    List<Integer> computerNumber = new ArrayList<>();

    public void generate() {
        while (computerNumber.size() < COMPUTER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComNum() {
        return computerNumber;
    }
}
