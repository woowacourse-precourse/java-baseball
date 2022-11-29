package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumberGenerator {
    static final int NUMBER_LENGTH = 3;

    List<Integer> numbers = new ArrayList<>();

    public List<String> generateRandomNumbers() {
        while (numbers.size() < NUMBER_LENGTH) {
            numbers.add(getNonDuplicateNumber());
        }
        return integerToString(numbers);
    }

    private int getNonDuplicateNumber() {
        int newRandomNumber = pickRandomNumber();
        while (isDuplicated(newRandomNumber)) {
            newRandomNumber = pickRandomNumber();
        }
        return newRandomNumber;
    }

    private boolean isDuplicated(int number) {
        return numbers.contains(number);
    }

    private List<String> integerToString(List<Integer> selectedNumbers) {
        return selectedNumbers.stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.toList());
    }

    private static Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private String getStringRandomNumbers(List<Integer> numbers) {
        return String.join("", numbers.toString());
    }
}
