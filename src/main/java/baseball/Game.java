package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Const.BALL;
import static baseball.Const.CORRECT;
import static baseball.Const.INPUT_REQUEST;
import static baseball.Const.NOTHING;
import static baseball.Const.RESTART;
import static baseball.Const.START;
import static baseball.Const.STRIKE;
import static baseball.Const.THREE_STRIKE;

public class Game {
    private CollectionBalls computer;
    private CollectionBalls user;
    private Result result;

    public Game() {
        computer = new CollectionBalls();
        user = new CollectionBalls();
        result = new Result();
    }

    public void run() {
        System.out.println(START);

        do {
            play();
        } while (restart());
    }

    private void play() {
        this.computer.generate();

        do {
            System.out.print(INPUT_REQUEST);
            this.user.convertInputToBall(Console.readLine());
            this.result.clear();
            this.result.getCompareResult(this.computer, this.user);
        } while (judgeToRestart());
    }

    private boolean judgeToRestart() {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println(NOTHING);
        }

        if (!(result.getStrike() == 0 && result.getBall() == 0)) {
            System.out.println(result);
//            System.out.print(getOutputStatementOfBall());
//            System.out.println(getOutputStatementOfStrike());
        }

        if (result.getStrike() == THREE_STRIKE) {
            System.out.println(CORRECT);
            return false;
        }

        return true;
    }

    private String getOutputStatementOfBall() {
        if (result.getBall() != 0) {
            return (result.getBall() + BALL);
        }

        return "";
    }

    private String getOutputStatementOfStrike() {
        if (result.getStrike() != 0) {
            return (result.getStrike() + STRIKE);
        }

        return "";
    }

    private boolean restart() {
        System.out.println(RESTART);

        return Integer.parseInt(Console.readLine()) == 1;
    }
}
