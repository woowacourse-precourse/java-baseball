package inputoutput;

import constants.Format;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    public boolean checkPlayerNumber(String playerNumber) {
        return checkPlayerNumberFormat(playerNumber) && checkAllDigitUnique(playerNumber);
    }

    private boolean checkPlayerNumberFormat(String playerNumber) {
        Format format = Format.PLAYER_NUMBER;

        return Pattern.matches(format.getRegex(), playerNumber);
    }

    private boolean checkAllDigitUnique(String playerNumber) {
        List<String> number = Arrays.asList(playerNumber.split(""));

        return number.stream()
                .allMatch(num ->
                        Collections.frequency(number, num) == 1);
    }

}
