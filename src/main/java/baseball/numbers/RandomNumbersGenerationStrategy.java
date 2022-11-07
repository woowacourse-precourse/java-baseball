package baseball.numbers;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumbersGenerationStrategy implements NumbersGenerationStrategy {
    private static final int NUMBERS_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_COUNT) {
            generateRandomNumber(numbers);
        }
        return numbers;
    }

    private void generateRandomNumber(List<Integer> numbers) {
        int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
