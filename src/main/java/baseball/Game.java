package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Const.BALL;
import static baseball.Const.CORRECT;
import static baseball.Const.INPUT_REQUEST;
import static baseball.Const.NOTHING;
import static baseball.Const.RESTART;
import static baseball.Const.START;
import static baseball.Const.SIZE;
import static baseball.Const.STRIKE;

public class Game {
    private Balls computer;
    private Balls user;
    private Result result;

    public Game() {
    }

    public void run() {
        System.out.println(START);

        do {
            play();
        } while (restart());
    }

    public void play() {
        this.computer = new Balls();
        this.user = new Balls();
        this.result = new Result();
        this.computer.generate();

        do {
            System.out.print(INPUT_REQUEST);
            this.user.convertInputToBall(Console.readLine());
            this.result.clear();
            this.result.getCompareResult(this.computer, this.user);
        } while (!judgeToEnd());
    }

    public boolean judgeToEnd() {
        if (result.getStrike() == SIZE) {
            System.out.println(CORRECT);
            return true;
        }

        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println(NOTHING);
        }

        if (!(result.getStrike() == 0 && result.getBall() == 0) && !(result.getStrike() == SIZE)) {
            printBall();
            printStrike();
            System.out.println();
        }

        return false;
    }

    public void printBall() {
        if (result.getBall() != 0) {
            System.out.print(result.getBall() + BALL);
        }
    }

    public void printStrike() {
        if (result.getStrike() != 0) {
            System.out.print(result.getStrike() + STRIKE);
        }
    }

    public boolean restart() {
        System.out.println(RESTART);
        Integer input = Integer.parseInt(Console.readLine());

        if (input == 1) {
            return true;
        }

        return false;
    }
}
