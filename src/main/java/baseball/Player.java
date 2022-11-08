package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String input() {
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

    private boolean validSuggestion(String suggestion) {
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

    public boolean continueGame() {
        final String CONTINUE_GAME = "1";
        String input = input();
        if (!validContinueGame(input)) {
            throw new IllegalArgumentException();
        }
        if (input.equals("1")) {
            return true;
        }
        return false;
    }

    private boolean validContinueGame(String input) {
        final String CONTINUE_GAME = "1";
        final String FINISH_GAME = "2";
        if (input.equals(CONTINUE_GAME)){
            return true;
        }
        if (input.equals(FINISH_GAME)){
            return true;
        }
        return false;
    }

}