package inputoutput;

import constants.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    public boolean checkPlayerNumber(String playerNumber) {
        if (checkPlayerNumberFormat(playerNumber) && checkAllDigitUnique(playerNumber)) {
            return true;
        }

        return false;
    }

    private boolean checkPlayerNumberFormat(String playerNumber) {
        Format format = Format.PLAYER_NUMBER;

        return Pattern.matches(format.getRegex(), playerNumber);
    }

    private boolean checkAllDigitUnique(String playerNumber) {
        List<String> number = new ArrayList<>(Arrays.asList(playerNumber.split("")));

        return number.stream()
                .allMatch(num ->
                        Collections.frequency(number, num) == 1);
    }

}
