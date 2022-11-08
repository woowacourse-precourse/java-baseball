package baseball.rules;

import baseball.ComputerNums;
import baseball.PlayerNums;

public abstract class Baseball {
    protected Integer nums;
    protected final ComputerNums computerNums;
    protected final PlayerNums playerNums;

    protected Baseball(ComputerNums computerNums, PlayerNums playerNums) {
        this.nums = 0;
        this.computerNums = computerNums;
        this.playerNums = playerNums;
    }

    protected abstract void calculator();
    protected abstract void compare(Integer computer, Integer player);

    protected void printNums(String rule) {
        if (this.nums != 0) {
            System.out.print(this.nums.toString()+rule);
        }
    }

    public Integer getNums() {
        return this.nums;
    }

}
