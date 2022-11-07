package computer;

import java.util.List;

public class Computer {

    private final List<Integer> targetNumber;

    public Computer() {
        this.targetNumber = RandomGenerator.generateDistinctThreeRandomNumber();
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }
}
