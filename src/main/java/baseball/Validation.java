package baseball;

import static baseball.Constant.ERR_MSG;
import static baseball.Constant.LENGTH_OF_NUMBER;

import java.util.List;

public class Validation {

    public void validateLengthOfNumber(List<Integer> number) {
        if (number.size() != LENGTH_OF_NUMBER) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

}
