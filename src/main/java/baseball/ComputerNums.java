package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNums {
    private final List<Integer> nums = new ArrayList<>();

    public ComputerNums() {
        generateRandomNums();
    }

    private void generateRandomNums() {
        while (this.nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!this.nums.contains(randomNumber)) {
                this.nums.add(randomNumber);
            }
        }
    }

    public List<Integer> getNums() {
        return nums;
    }
}
