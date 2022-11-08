package baseball.validator;

import baseball.exception.CantBlankOrNullInputException;
import baseball.exception.OnlyNumberConsistOneOrTwoInputException;

import java.util.Objects;

public class RetryValidator {

    private RetryValidator(){

    }
    private static final String NUMBER_REGEXP = "^[1-2]";

    public static void validate(String input) {
        validateBlank(input);
        isNumberOneOrTwo(input);
    }

    public static void isNumberOneOrTwo(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new OnlyNumberConsistOneOrTwoInputException();
        }
    }

    private static void validateBlank(final String input){
        if (isBlank(input)){
            throw new CantBlankOrNullInputException();
        }
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
