package baseball;

import static baseball.Constraint.STRIKE;

import java.util.List;

public class Strike {
    private Integer strikeNums;
    private ComputerNums computerNums;
    private PlayerNums playerNums;

    public Strike(ComputerNums computerNums, PlayerNums playerNums) {
        this.strikeNums = 0;
        this.computerNums = computerNums;
        this.playerNums = playerNums;
    }

    public void calculator() {
        for (int i = 0; i < 3; i++) {
            compare(computerNums.getNums().get(i), playerNums.getNums().get(i));
        }
        printStrike();
    }

    private void compare(Integer computer,Integer player) {
        if (computer.equals(player)) {
            this.strikeNums += 1;
        }
    }

    private void printStrike() {
        if (strikeNums != 0) {
            System.out.print(STRIKE+strikeNums.toString());
        }
    }

    public Integer getStrikeNums() {
        return strikeNums;
    }
}
