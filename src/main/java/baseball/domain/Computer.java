package baseball.domain;

import baseball.util.RandomNumberMaker;
import java.util.List;

public class Computer {
    private List<Integer> gameNumber;
    private RandomNumberMaker numberMaker = new RandomNumberMaker();

    public List<Integer> getComputerGameNumbers() {
        return gameNumber;
    }

    public void setupGameNumbers() {
        gameNumber = numberMaker.generateComputerGameNumber();
    }
}