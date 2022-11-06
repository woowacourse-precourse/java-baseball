package inputoutput;

import constants.Format;

import java.util.regex.Pattern;

public class Validation {
    public boolean validatePlayerNumber(String playerNumber) {
        if (validateFormatPlayerNumber(playerNumber)) {
            return true;
        }

        return false;
    }

    private boolean validateFormatPlayerNumber(String playerNumber) {
        Format format = Format.PLAYER_NUMBER;

        if (!Pattern.matches(format.getRegex(), playerNumber)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

}
