package baseball.domain;

import java.util.List;

public abstract class Player {
    private List<Integer> nums;

    public void setNums(List<Integer> nums){
        this.nums = nums;
    }

    public List<Integer> getNums() {
        return nums;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nums=" + nums +
                '}';
    }
}
