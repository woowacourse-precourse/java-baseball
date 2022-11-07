package baseball.computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> gameNumber;

    public Computer() {
        gameNumber = new ArrayList<>();
    }

    public void initComputer() {
        gameNumber = RandomNumberGenerator.getRandomNumber();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }
}
