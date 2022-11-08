package baseball.computer;

import utils.RandomGeneratorUtil;

import java.util.List;

public class Computer {

    private final List<Integer> targetNumber;

    public Computer() {
        this.targetNumber = RandomGeneratorUtil.generateDistinctThreeRandomNumber();
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }
}
