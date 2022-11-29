package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List randomNumber;

    public Computer(List randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List getRandomNumber() {
        return randomNumber;
    }
}
