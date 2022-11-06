package baseball.exception;

import java.util.HashSet;

public class InputException {
    private final static String RESTART_OR_EXIT = "[1-2]";
    private final static String GUESS_FORMAT = "[1-9]{3}";
    private final static String FORMAT_ERROR_MESSAGE = "올바른 형식으로 입력해주세요.";

    private boolean areNotUniqueNumbers(String playerGuess) {
        HashSet<Character> guessNumbers = new HashSet<>();

        for (char guessNumber : playerGuess.toCharArray()) {
            if (guessNumbers.contains(guessNumber)) {
                return true;
            }
            guessNumbers.add(guessNumber);
        }

        return false;
    }

    public void validateGuess(String playerGuess) {
        if ( !playerGuess.matches(GUESS_FORMAT) || areNotUniqueNumbers(playerGuess)) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    public void validateChoice(String playerChoice) {
        if (!playerChoice.matches(RESTART_OR_EXIT)) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }
}
