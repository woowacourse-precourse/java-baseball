package baseball.validator;

import baseball.constant.Finish;
import baseball.exception.InvalidFinishCodeException;
import java.util.Arrays;

public class FinishValidator implements Validator {

    @Override
    public boolean checkValid(String input) {
        boolean isValid = Arrays.stream(Finish.values())
                .anyMatch(finish -> finish.getCode().equals(input));
        if (!isValid) {
            throw new InvalidFinishCodeException();
        }
        return true;
    }
}
