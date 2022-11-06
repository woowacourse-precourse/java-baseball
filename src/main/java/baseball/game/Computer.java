package baseball.game;

import baseball.game.utils.NumberFactory;
import baseball.game.utils.ScoreBoard;
import baseball.game.utils.ScoreCalculator;
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
