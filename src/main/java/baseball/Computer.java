package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Exception.DIGIT_NUMBER;
import static baseball.Exception.MAX_NUMBER;
import static baseball.Exception.MIN_NUMBER;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public RandomNumbers generate() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < DIGIT_NUMBER) {
            addRandomNumber(randomNumbers);
        }

        return toRandomNumbers(randomNumbers);
    }

    private void addRandomNumber(List<Integer> randomNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        if (randomNumbers.size() != DIGIT_NUMBER) {
            randomNumbers.add((randomNumber));
        }
    }

    private RandomNumbers toRandomNumbers(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .map(RandomNumber :: valueOf)
                .collect(collectingAndThen(toList(), RandomNumbers :: new));
    }
}
