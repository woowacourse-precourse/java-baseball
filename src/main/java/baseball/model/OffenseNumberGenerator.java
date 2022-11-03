package baseball.model;

import baseball.view.UserInput;

import java.util.List;


public class OffenseNumberGenerator {
    private UserInput userInput;

    public OffenseNumberGenerator() {
        userInput = new UserInput();
    }

    public List<Integer> generateOffenseNumbers() {
        String input = userInput.input();
        validateOnlyThreeNumbers(input);
        List<Integer> offenseNumbers = Utils.convertStringToIntegerList(input);
        validateDifferentNumbers(offenseNumbers);
        return offenseNumbers;
    }

    private void validateOnlyThreeNumbers(String input) {
        String pattern = "^[0-9]*$";

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDifferentNumbers(List<Integer> unvalidatedNumbers) {
        if (unvalidatedNumbers.stream().distinct().count() != 3L) {
            throw new IllegalArgumentException();
        }
    }
}
