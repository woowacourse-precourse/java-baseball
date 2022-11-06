package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumGenerator {
    public final List<Integer> NUMS;

    public ComputerNumGenerator() {
        NUMS = generate();
    }

    public List<Integer> generate() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() != Constants.INPUT_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNum)) {
                nums.add(randomNum);
            }
        }
        return nums;
    }
}
