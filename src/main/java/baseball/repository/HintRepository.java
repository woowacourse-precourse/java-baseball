package baseball.repository;

import baseball.model.hint.Hint;
import baseball.view.print.PrintHint;
import java.util.List;

public class HintRepository extends Hint {
    public HintRepository() {
        super();
    }

    @Override
    public int getBall() {
        return super.getBall();
    }

    @Override
    public int getStrike() {
        return super.getStrike();
    }

    public void compare(ComputerNumberRepository computerNumberRepository,
                        PlayerNumberRepository playerNumberRepository) {
        List<Integer> computerNumberList = computerNumberRepository.getNumberList();
        List<Integer> playerNumberList = playerNumberRepository.getNumberList();
        calculateBall(computerNumberList, playerNumberList);
        calculateStrike(computerNumberList, playerNumberList);
    }

    public void printHint() {
        if (this.getBall() != 0 && this.getStrike() == 0) {
            PrintHint.printBall(this.getBall());
        }
        if (this.getBall() == 0 && this.getStrike() != 0) {
            PrintHint.printStrike(this.getStrike());
        }
        if (this.getBall() != 0 && this.getStrike() != 0) {
            PrintHint.printBallAndStrike(this.getBall(), this.getStrike());
        }
        if (this.getBall() == 0 && this.getStrike() == 0) {
            PrintHint.printNothing();
        }
    }

    @Override
    public boolean isEndGame() {
        return super.isEndGame();
    }
}