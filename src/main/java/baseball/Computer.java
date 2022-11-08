package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private List<Integer> computerNumbers;

    static final int MAX_SIZE = 3;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;

    public void resetRandomNumbers() {
        computerNumbers = new ArrayList<>();
    }

    public List<Integer> pickRandomNumbers() {
        resetRandomNumbers();
        while (computerNumbers.size() < MAX_SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computerNumbers.contains(randomNum)) {
                computerNumbers.add(randomNum);
            }
        }
        return computerNumbers;
    }
}
