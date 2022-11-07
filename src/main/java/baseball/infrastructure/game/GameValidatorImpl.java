package baseball.infrastructure.game;

import baseball.domain.game.service.GameValidator;
import baseball.global.utils.message.ErrorMessage;
import baseball.global.utils.message.Number;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameValidatorImpl implements GameValidator {

    private static final Pattern isNumber = Pattern.compile("^[1-9]*?");

    @Override
    public void validateNumber(String number) {
        isThreeDigits(number);
        isInteger(number);
        isNotDuplicate(number);
    }

    @Override
    public void validateContinueOrStop(String response) {
        if (!(response.equals(Number.CONTINUE) || response.equals(Number.STOP))) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_RESPONSE);
        }
    }

    private void isThreeDigits(String number) {
        if (number.toCharArray().length != Number.THREE) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_THREE_DIGITS);
        }
    }

    private void isInteger(String number) {
        if (!isNumber.matcher(number).matches()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }
    }

    private void isNotDuplicate(String number) {
        final Set<String> set = Stream.of(number.split(""))
                .collect(Collectors.toUnmodifiableSet());
        if (set.size() != Number.THREE) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
        }
    }
}
