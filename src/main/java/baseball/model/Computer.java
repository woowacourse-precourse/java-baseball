package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    public Computer() {
        randomNumber = new ArrayList<>();
    }

    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
