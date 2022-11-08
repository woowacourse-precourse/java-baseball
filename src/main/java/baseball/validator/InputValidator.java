package baseball.validator;

import baseball.constant.Config;
import baseball.constant.Message;
import baseball.constant.State;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validatePlayerNumber(String playerNumber) {
        validateType(playerNumber);
        validateDigitLength(playerNumber);
        validateDuplication(playerNumber);
        validateRange(playerNumber);
    }

    private static void validateType(String number) {
        for (char digit : number.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
            }
        }
    }

    private static void validateDigitLength(String playerNumber) {
        if(playerNumber.length() != Config.DIGIT_SIZE) {
            throw new IllegalArgumentException(Message.DIGIT_LENGTH_EXCEPTION);
        }
    }

    private static void validateDuplication(String playerNumber) {
        String[] digits = playerNumber.split("");
        Set<String> deduplicationNumbers = new HashSet<>(Arrays.asList(digits));

        if(playerNumber.length() != deduplicationNumbers.size()) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }
    }

    private static void validateRange(String playerNumber) {
        for (char digit : playerNumber.toCharArray()) {
            int digitNumber = Character.getNumericValue(digit);

            if (Config.DIGIT_MIN > digitNumber || Config.DIGIT_MAX < digitNumber) {
                throw new IllegalArgumentException(Message.DIGIT_RANGE_EXCEPTION);
            }
        }
    }

    public static void validateStateNumber(String stateNumber) {
        validateType(stateNumber);
        validateStateLength(stateNumber);
        validateNumber(stateNumber);
    }

    private static void validateStateLength(String stateNumber) {
        if(stateNumber.length() != Config.STATE_SIZE) {
            throw new IllegalArgumentException(Message.STATE_LENGTH_EXCEPTION);
        }
    }

    private static void validateNumber(String stateNumber) {
        if(!State.isValidNumber(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_NUMBER_EXCEPTION);
        }
    }
}
