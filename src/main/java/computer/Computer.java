package computer;

import java.util.List;

public class Computer {

    private final List<Integer> targetNumber;

    public Computer(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }
}
