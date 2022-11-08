package baseball.rules;

import static baseball.Constraint.BALL;

import baseball.ComputerNums;
import baseball.PlayerNums;

public class Ball extends Baseball {


    public Ball(ComputerNums computerNums, PlayerNums playerNums) {
        super(computerNums,playerNums);
        calculator();
    }

    @Override
    protected void calculator() {
        for (int i = 0; i < 3; i++) {
            compare(computerNums.getNums().get(i), playerNums.getNums().get(i));
        }
        printNums(BALL+" ");
    }

    @Override
    protected void compare(Integer computer, Integer player) {
        if (!computer.equals(player) && computerNums.getNums().contains(player)) {
            this.nums += 1;
        }
    }




}
