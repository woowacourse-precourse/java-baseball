package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static int MAX_NUMBER_SIZE = 3;

    List<Integer> computer = new ArrayList<>();

    public List<Integer> generateRandomNumber() {
        while (computer.size() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            addNumberIfNotContained(randomNumber);
        }
        return computer;
    }

    public void addNumberIfNotContained(Integer number) {
        if (computer.contains(number) == false) {
            computer.add(number);
        }
    }

}
