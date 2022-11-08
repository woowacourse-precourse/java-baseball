package baseball.rules;

import static baseball.Constraint.STRIKE;

import baseball.ComputerNums;
import baseball.PlayerNums;
import baseball.rules.Baseball;

public class Strike extends Baseball {

    public Strike(ComputerNums computerNums, PlayerNums playerNums) {
        super(computerNums,playerNums);
        calculator();
    }

    @Override
    protected void calculator() {
        for (int i = 0; i < 3; i++) {
            compare(computerNums.getNums().get(i), playerNums.getNums().get(i));
        }
        printNums(STRIKE);
    }
    @Override
    protected void compare(Integer computer, Integer player) {
        if (computer.equals(player)) {
            this.nums += 1;
        }
    }



}
