package validator;

import constant.ErrorMessage;
import constant.GuideMessage;

public class Validator {

    public static void checkStartOrEndInput(String input) throws IllegalArgumentException {
        if (input.equals(GuideMessage.ONE) || input.equals(GuideMessage.TWO)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_START_OR_END);
    }
}
