package baseball.opponent;

import java.util.List;

public class ComputerOpponent {

    private List<Integer> randomNumbers;

    public ComputerOpponent() {
        this.randomNumbers = RandomNumberGenerator.generate();
    }
}
