package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> gameNumbers = new ArrayList<>();

    public void makeRandomNumbers(){
        List<Integer> randomNums = NumberGenerator.make3RandomNum();
        setGameNumbers(randomNums);
    }
    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    public void setGameNumbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }
}
