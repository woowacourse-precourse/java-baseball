package baseball.model;

import baseball.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> answer = new ArrayList<>();

    public List<Integer> toList(String input) {
        validateInput(input);
        answer = inputToNumbers(input);
        return answer;
    }

    private void validateInput(String input) {
        InputValidator.validate(input);
    }


    private List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = inputToInt(input, index);
            numbers.add(number);
        }

        return numbers;
    }

    private int inputToInt(String input, int index) {
        return input.charAt(index) - '0';
    }
}
