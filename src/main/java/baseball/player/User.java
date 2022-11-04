package baseball.player;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNumbers;

    public void setUser(String inputNumbers) {
        this.userNumbers = generateNumbers(inputNumbers);
    }

    private List<Integer> generateNumbers(String inputNumbers) throws IllegalArgumentException {

        if (isNotNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = changeStringToInteger(inputNumbers);

        if (isNotThreeLength(numbers) || isDuplication(numbers)) {
            throw new IllegalArgumentException();
        }

        return numbers;

    }

    private boolean isDuplication(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isNotThreeLength(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    private List<Integer> changeStringToInteger(String inputNumbers) {

        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < inputNumbers.length(); index++) {

            String stringNumber = String.valueOf(inputNumbers.charAt(index));
            int integerNumber = Integer.parseInt(stringNumber);

            numbers.add(integerNumber);

        }

        return numbers;

    }

    private boolean isNotNumber(String inputNumbers) {

        for (int index = 0; index < inputNumbers.length(); index++) {

            char ch = inputNumbers.charAt(index);

            if (!Character.isDigit(ch) || ch == '0') {
                return true;
            }
        }

        return false;

    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
