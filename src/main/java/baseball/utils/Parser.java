package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import static baseball.vo.ValidationMsg.NOT_EXIST_NUMBER_RANGE_EXCEPTION;
import static baseball.vo.ValidationMsg.NOT_FORMATTING_EXCEPTION;

public class Parser {

    public List<Integer> parsePlayerNumbers(String input) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            answer.add(convertCharToInt(input, i));
        }

        return answer;
    }

    private int convertCharToInt(String input, int index) {
        return input.charAt(index) - '0';
    }

    public int parseInt(String input) {
        isParsable(input);
        return Integer.parseInt(input);
    }

    private void isParsable(String input) {
        if (!validateFormatNumber(input)) {
            throw new NumberFormatException(NOT_FORMATTING_EXCEPTION.getMessage());
        }

        if (!validateOneOrTwo(input)) {
            throw new IllegalArgumentException(NOT_EXIST_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private boolean validateOneOrTwo(String input) {
        return input.equals("1") || input.equals("2");
    }

    private boolean validateFormatNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
