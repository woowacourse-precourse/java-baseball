package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.INPUT_LENGTH;

public class ComputerNumGenerator {
    public final List<Integer> NUMS;

    public ComputerNumGenerator() {
        NUMS = generate();
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
