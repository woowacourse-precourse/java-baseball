package baseball;

import baseball.utils.RandomUtils;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public Computer() {
        this.randomNumbers = RandomUtils.pickThreeRandomNumbers();
    }
}
