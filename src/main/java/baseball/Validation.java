package baseball;

import static baseball.Constant.ERR_MSG;
import static baseball.Constant.LENGTH_OF_NUMBER;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    public void validateLengthOfNumber(List<Integer> number) {
        if (number.size() != LENGTH_OF_NUMBER) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    public void validateUnlike(List<Integer> number) {
        number = number.stream().distinct().collect(Collectors.toList());
        if (number.size() != LENGTH_OF_NUMBER) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }
    
}
