package baseball.validator;

import baseball.Config;
import baseball.Message;
import baseball.State;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void validatePlayerNumber(String playerNumber) {
        if (!isValidType(playerNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidDigitLength(playerNumber)) {
            throw new IllegalArgumentException(Message.DIGIT_LENGTH_EXCEPTION);
        }

        if (!isValidDuplication(playerNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }

        if (!isValidRange(playerNumber)) {
            throw new IllegalArgumentException(Message.DIGIT_RANGE_EXCEPTION);
        }
    }

    private boolean isValidType(String number) {
        for (char digit : number.toCharArray()) {
            if (Character.isLetter(digit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidDigitLength(String playerNumber) {
        return playerNumber.length() == Config.DIGIT_SIZE;
    }

    private boolean isValidDuplication(String playerNumber) {
        String[] digits = playerNumber.split("");
        Set<String> deduplicationNumbers = new HashSet<>(Arrays.asList(digits));

        return playerNumber.length() == deduplicationNumbers.size();
    }

    private boolean isValidRange(String playerNumber) {
        for (char digit : playerNumber.toCharArray()) {
            int digitNumber = Character.getNumericValue(digit);

            if (Config.DIGIT_MIN > digitNumber || Config.DIGIT_MAX < digitNumber) {
                return false;
            }
        }
        return true;
    }

    public void validateStateNumber(String stateNumber) {
        if (!isValidType(stateNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidStateLength(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_LENGTH_EXCEPTION);
        }

        if (!isValidNumber(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_NUMBER_EXCEPTION);
        }
    }

    private boolean isValidStateLength(String stateNumber) {
        return stateNumber.length() == Config.STATE_SIZE;
    }

    private boolean isValidNumber(String stateNumber) {
        for (State state : State.values()) {
            if (state.getNumber().equals(stateNumber)) {
                return true;
            }
        }

        return false;
    }
}
