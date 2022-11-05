package baseball;

import baseball.exception.NotSuitableRegexException;
import baseball.exception.OverlapNumberException;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void validateRestartMessage(String message) {
        validateRegex(message, ValidRegex.RESTART_REQUEST);
    }

    public void validateGuessValueMessage(String message) {
        validateRegex(message, ValidRegex.GUESS_VALUE);
        validateOverlapNumber(message);
    }

    private void validateOverlapNumber(String message) {
        Set<Character> overlapCheckSet = toMessageSet(message);
        if (isOverlap(overlapCheckSet)) {
            throw new OverlapNumberException();
        }
    }

    private Set<Character> toMessageSet(String message) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < message.length(); i++) {
            set.add(message.charAt(i));
        }
        return set;
    }

    private boolean isOverlap(Set<Character> set) {
        return set.size() < BallGenerator.DIGIT_NUMBER;
    }

    private void validateRegex(String message, ValidRegex validRegex) {
        if (!message.matches(validRegex.getRegex())) {
            throw new NotSuitableRegexException();
        }
    }
}
