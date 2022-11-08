package baseball.computer;

import baseball.computer.generator.NumberGenerator;
import baseball.computer.generator.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> gameNumber;

    public Computer() {
        gameNumber = new ArrayList<>();
    }

    public void initComputer() {
        gameNumber = NumberGenerator.getNumber();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }
}
