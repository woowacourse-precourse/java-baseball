package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.NumbersValidator.*;

public class Numbers {
    private List<Integer> numbers;

    public Numbers() {
        GenerateRandomNumbers generateRandomNumbers = new GenerateRandomNumbers();
        this.numbers = generateRandomNumbers.generate();
    }

    public Numbers(String input) {
        validateNonNumeric(input);
        validateDigit(input);
        validateDuplicateNumber(input);
        validationRange(input);

        this.numbers = transformInputNumbers(input);
    }

    private List<Integer> transformInputNumbers(String input) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }
}