package baseball;

import static baseball.Constraint.NOTHING;
import static baseball.Constraint.OPENING_MENT;

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
        // ===================
        System.out.println(this.computerNums.getNums());
        // ===================
        do {
            playerNums.setNums();
        } while (compare());

    }

    private boolean compare() {
        Ball ball = new Ball(this.computerNums, this.playerNums);
        Strike strike = new Strike(this.computerNums, this.playerNums);
        ball.calculator();
        strike.calculator();
        if (ball.getBallNums() == 0 && strike.getStrikeNums() == 0) {
            System.out.println(NOTHING);
        }
        return strike.getStrikeNums() != 3;
    }

    public ComputerNums getComputerNums() {
        return computerNums;
    }

    public PlayerNums getPlayerNums() {
        return playerNums;
    }
}
