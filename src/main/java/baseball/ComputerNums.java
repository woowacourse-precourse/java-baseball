package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNums implements Nums{
    private final List<Integer> nums = new ArrayList<>();

    public ComputerNums() {

    }

    private void generateRandomNums() {
        while (this.nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!this.nums.contains(randomNumber)) {
                this.nums.add(randomNumber);
            }
        }
    }

    @Override
    public void setNums() {
        this.nums.clear();
        generateRandomNums();
    }

    @Override
    public List<Integer> getNums() {
        return this.nums;
    }
}
