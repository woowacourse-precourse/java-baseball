package baseball;

import static baseball.Constant.ERR_MSG;
import static baseball.Constant.LENGTH_OF_NUMBER;
import static baseball.Constant.NUM_MAX_RANGE;
import static baseball.Constant.NUM_MIN_RANGE;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    public void validate(List<Integer> number) throws IllegalArgumentException {
        validateLengthOfNumber(number);
        validateUnlike(number);
        validateBetweenOneAndNine(number);
    }
    
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

    public void validateBetweenOneAndNine(List<Integer> number) {
        for (Integer subNumber : number) {
            if (subNumber < NUM_MIN_RANGE || NUM_MAX_RANGE < subNumber) {
                throw new IllegalArgumentException(ERR_MSG);
            }
        }
    }

}
