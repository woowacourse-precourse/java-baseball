package baseball.domain.computer;

import baseball.domain.computer.generator.NumberGenerator;
import java.util.*;

import static baseball.utils.Constants.*;

public class Computer {
    private NumberGenerator numberGenerator;
    private List<Integer> randomNumbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void setRandomNumbers() {
        this.randomNumbers = numberGenerator.generateRandomNumbers(
                BASEBALL_MIN_VALUE,
                BASEBALL_MAX_VALUE,
                BASEBALL_DIGIT_LENGTH
        );
    }

    public List<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }
}
