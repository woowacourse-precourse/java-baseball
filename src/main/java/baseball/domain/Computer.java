package baseball.domain;


import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> Number = new ArrayList<>();

    public List<Integer> getRandomNumber() {
        return Number;
    }

    public void setRandomNumber(List<Integer> randomNumber) {
        this.Number = randomNumber;
    }
}
