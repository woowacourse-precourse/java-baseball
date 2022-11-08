package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Constant.*;

public class Computer {
    private final List<Integer> randomNumbers;

    public static Computer createRandomNumbers() {
        return new Computer(generateNumbers());
    }

    private Computer(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != RANDOM_NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
            if (!isDuplicateNumber(randomNumber, numbers)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static boolean isDuplicateNumber(int randomNumber, List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
