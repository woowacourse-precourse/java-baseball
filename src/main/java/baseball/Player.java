package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Player {
    public void validateNumber(String playerNumber) {
        if (!isValidType(playerNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidLength(playerNumber)) {
            throw new IllegalArgumentException(Message.LENGTH_EXCEPTION);
        }

        if (!isValidDuplication(playerNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }

        if (!isValidRange(playerNumber)) {
            throw new IllegalArgumentException(Message.RANGE_EXCEPTION);
        }
    }

    private boolean isValidType(String playerNumber) {
        for (char digit : playerNumber.toCharArray()) {
            if (Character.isLetter(digit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLength(String playerNumber) {
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

            if (Config.MIN_NUM > digitNumber || Config.MAX_NUM < digitNumber) {
                return false;
            }
        }
        return true;
    }
}
