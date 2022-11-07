package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomGeneratedNumber;
    private int strike;
    private int ball;

    public void generateRandomNumber() {
        randomGeneratedNumber = new ArrayList<>();
        while (this.randomGeneratedNumber.size() < Constants.DIGIT_LENGTH) {
            int digit = Randoms.pickNumberInRange(Constants.LOWER_BOUND, Constants.UPPER_BOUND);
            if (!this.randomGeneratedNumber.contains(digit)) {
                this.randomGeneratedNumber.add(digit);
            }
        }
    }
}
