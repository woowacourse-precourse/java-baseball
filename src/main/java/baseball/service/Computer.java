package baseball.service;

import java.util.List;

public class Computer {
    private final ThreeNumber number;

    public Computer() {
        number = new ThreeNumber();
    }

    public List<Integer> getThreeNumber() {
        return number.getNumber();
    }

    public int getNumber(int index) {
        return number.getNumber().get(index);
    }

    public void generateRandomNumber() {
        number.generate();
    }
}
