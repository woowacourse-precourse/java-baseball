package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.Constants.INPUT_LENGTH;

public class Computer {
    public final List<Integer> computerNum;

    public Computer() {
        this.computerNum = generate();
    }

    public List<Integer> generate() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() != INPUT_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            addNotDuplicateNumbers(nums, randomNum);
        }
        return nums;
    }

    public void addNotDuplicateNumbers(List<Integer> nums, int randomNum) {
        if (!nums.contains(randomNum)) {
            nums.add(randomNum);
        }
    }
}
