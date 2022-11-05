package baseball.game.player;

import baseball.game.NumberFactory;
import baseball.game.ScoreBoard;
import baseball.game.ScoreCalculator;
import java.util.List;

public class Computer {

    private final List<Integer> targetNumbers;

    public Computer() {
        this.targetNumbers = NumberFactory.createRandomNumbers();
    }

    public ScoreBoard scoreCheck(List<Integer> requestNumbers){
        return ScoreCalculator.calculate(targetNumbers, requestNumbers);
    }
}
