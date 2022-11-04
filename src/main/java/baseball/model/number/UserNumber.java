package baseball.model.number;

import baseball.model.util.Validation;

import static baseball.model.util.Constant.*;
import static baseball.model.util.Utilization.convertStringToIntegerList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public abstract class UserNumber {
    public static NumberDto generate() {
        String userInput = readLine();
        if (!UserNumberValidation.validate(userInput)) {
            throw new IllegalArgumentException();
        }
        return new NumberDto(convertStringToIntegerList(userInput));
    }

    abstract static class UserNumberValidation extends Validation {
        public static boolean validate(String userInput) {
            return validateNotNull(userInput)
                    && isInteger(userInput)
                    && validateStringLength(userInput, NUMBER_LENGTH)
                    && validateEachUserNumberInRange(userInput)
                    && validateNumberNotRepeated(convertStringToIntegerList(userInput), NUMBER_LENGTH);
        }

        private static boolean validateEachUserNumberInRange(String userInput) {
            for (int number : convertStringToIntegerList(userInput)) {
                if (!validateIntegerRange(number, MIN_NUMBER_VALUE, MAX_NUMBER_VALUE))
                    return false;
            }
            return true;
        }
    }
}
