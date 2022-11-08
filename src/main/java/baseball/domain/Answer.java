package baseball.domain;

import java.util.List;

public class Answer {
    private final List<Integer> nums;

    public Answer(List<Integer> nums) {
        this.nums = nums;
    }

    public boolean isContain(int num) {
        return nums.contains(num);
    }

    public int getIndex(int num) {
        return nums.indexOf(num);
    }
}
