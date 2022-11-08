package baseball.validator;

import static baseball.constant.Rules.END_INCLUSIVE;
import static baseball.constant.Rules.NUMBER_LENGTH;
import static baseball.constant.Rules.START_INCLUSIVE;

import baseball.exception.NotDistinctException;
import baseball.exception.WrongLengthException;
import baseball.exception.WrongRangeException;

public class AnswerValidator implements Validator {

    @Override
    public boolean checkValid(String input) {
        if (!checkLength(input)) {
            throw new WrongLengthException();
        }
        if (!checkRange(input)) {
            throw new WrongRangeException();
        }
        if (!checkDistinct(input)) {
            throw new NotDistinctException();
        }
        return true;
    }

    private boolean checkLength(String input) {
        return input.length() == NUMBER_LENGTH;
    }

    private boolean checkRange(String input) {
        String regex = String.format(
                "^[%d-%d]{%d}$",
                START_INCLUSIVE,
                END_INCLUSIVE,
                NUMBER_LENGTH
        );
        return input.matches(regex);
    }

    private boolean checkDistinct(String input) {
        return input.chars().distinct().count() == NUMBER_LENGTH;
    }
}
