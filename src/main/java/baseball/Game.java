package baseball;

import static baseball.Constraint.ASK_CONTINUE_MENT;
import static baseball.Constraint.CLOSING_MENT;
import static baseball.Constraint.CONTINUE;
import static baseball.Constraint.NOTHING;
import static baseball.Constraint.OPENING_MENT;

import baseball.rules.Ball;
import baseball.rules.Strike;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final ComputerNums computerNums;
    private final PlayerNums playerNums;

    public Game() {
        this.computerNums = new ComputerNums();
        this.playerNums = new PlayerNums();
    }

    public String opening() {
        return OPENING_MENT;
    }

    public void doGame() throws IllegalArgumentException{
        this.computerNums.setNums();
        do {
            playerNums.setNums();
        } while (compare());
        closing();

    }

    private void closing() {
        System.out.println(CLOSING_MENT);
    }

    private boolean compare() {
        Ball ball = new Ball(this.computerNums, this.playerNums);
        Strike strike = new Strike(this.computerNums, this.playerNums);
        if (ball.getNums() == 0 && strike.getNums() == 0) {
            System.out.println(NOTHING);
        }
        return strike.getNums() != 3;
    }


    public boolean askContinue() {
        System.out.println(ASK_CONTINUE_MENT);
        return Console.readLine().equals(CONTINUE);
    }
}
