package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    String input() {
        return Console.readLine();
    }

    public List<Integer> suggest() {
        String input = input();
        if (!validSuggestion(input)) {
            throw new IllegalArgumentException();
        }
        List<Integer> suggestion;
        suggestion = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return suggestion;
    }

    boolean validSuggestion(String suggestion) {
        int SUGGESTION_LENGTH = 3;
        String INVALID_NUMBER = "0";
        if (suggestion.length() != SUGGESTION_LENGTH) {
            return false;
        }
        if (suggestion.contains(INVALID_NUMBER)) {
            return false;
        }
        boolean isNumeric = suggestion.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            return false;
        }
        return true;
    }

    boolean continueGame() {
        return false;
    }

    boolean validContinueGame() {
        return false;
    }

}