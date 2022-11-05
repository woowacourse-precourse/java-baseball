package baseball;

import static baseball.Constraint.BALL;

import java.util.List;

public class Ball {
    private Integer ballNums;
    private ComputerNums computerNums;
    private PlayerNums playerNums;

    public Ball(ComputerNums computerNums, PlayerNums playerNums) {
        this.ballNums = 0;
        this.computerNums = computerNums;
        this.playerNums = playerNums;
    }

    public void calculator() {
        for (int i = 0; i < 3; i++) {
            compare(computerNums.getNums().get(i), playerNums.getNums().get(i));
        }
        printBall();
    }

    private void compare(Integer computer, Integer player) {
        if (!computer.equals(player) && computerNums.getNums().contains(player)) {
            this.ballNums += 1;
        }
    }

    private void printBall() {
        if (ballNums != 0) {
            System.out.print(ballNums.toString()+BALL+" ");
        }
    }

    public Integer getBallNums() {
        return ballNums;
    }
}
