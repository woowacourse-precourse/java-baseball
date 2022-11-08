package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> createNums(int count) {
        nums.clear();
        while (nums.size() < count) {
            Ball ball = new Ball(createNums());
            if(!nums.contains(ball.getNumber())) {
                nums.add(ball.getNumber());
            }
        }
        return nums;
    }

    public int createNum() {
        return Randoms.pickNumberInRange(Ball.BEGIN, Ball.END);
    }
}
