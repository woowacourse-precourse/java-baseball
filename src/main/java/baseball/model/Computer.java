package baseball.model;

import baseball.dto.Number;
import baseball.dto.Numbers;

public class Computer {

    private Numbers computerNumbers;

    public Computer () {}

    public void pickRandomNumbers() {
        this.computerNumbers = Numbers.createRandomNumbers();
    }

    public Number findComputerNumber(int index) {
        return this.computerNumbers.findNumber(index);
    }
}
