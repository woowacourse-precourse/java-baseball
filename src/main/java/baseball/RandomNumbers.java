package baseball;

import java.util.List;

public class RandomNumbers {
    private final List<RandomNumber> randomNumbers;

    public RandomNumbers(List<RandomNumber> randomNumbers) {
        Exception.randomNumberDuplicationException(randomNumbers);
        this.randomNumbers = randomNumbers;
    }
}
