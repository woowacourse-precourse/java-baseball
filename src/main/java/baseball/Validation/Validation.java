package baseball.Validation;

import java.util.ArrayList;
import java.util.List;

import static baseball.Message.ErrorMessage.*;

public class Validation {
    public void check(String userNumbers) {
        checkLength(userNumbers);
        checkZero(userNumbers);
        checkBlank(userNumbers);
        checkNotNumericCharacter(userNumbers);
        checkDuplicatedNumber(userNumbers);
    }

    private void checkLength(String userNumbers) {
        if (userNumbers.length() != 3) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.toMessage());
        }
    }

    private void checkZero(String userNumbers) {
        if (userNumbers.indexOf("0") > -1) {
            throw new IllegalArgumentException(ZERO_EXISTS.toMessage());
        }
    }

    private void checkBlank(String userNumbers) {
        if (userNumbers.indexOf(" ") > -1) {
            throw new IllegalArgumentException(BLANK_EXISTS.toMessage());
        }
    }

    private void checkNotNumericCharacter(String userNumbers) {
        String[] userNumbersArray = userNumbers.split("");

        for (String number : userNumbersArray) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_ALLOWED_CHARACTER.toMessage());
            }
        }
    }

    private void checkDuplicatedNumber(String userNumbers) {
        List<String> checkList = new ArrayList<>();

        String[] userNumbersArray = userNumbers.split("");

        for (String number : userNumbersArray) {
            if (checkList.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBERS.toMessage());
            } else {
                checkList.add(number);
            }
        }
    }
}
