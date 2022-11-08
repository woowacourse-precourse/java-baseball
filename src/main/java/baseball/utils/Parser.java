package baseball.utils;

import java.util.ArrayList;
import java.util.List;

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
        return Integer.parseInt(input);
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
