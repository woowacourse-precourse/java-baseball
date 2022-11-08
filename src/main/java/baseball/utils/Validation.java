package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.NUMBER_LIMIT;
import static baseball.Constant.USER_INPUT_ERROR;

public class Validation {

    public void validateInput(List<Integer> number) throws IllegalArgumentException{
        validateLengthOfNumber(number);
        validateDuplicateNumber(number);
        validateNumberInRange(number);
    }


    public void validateLengthOfNumber(List<Integer> number){
        if(number.size() != NUMBER_LIMIT){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
    }
    public void validateDuplicateNumber(List<Integer> number){
        number = number.stream().distinct().collect(Collectors.toList());
        if(number.size() != NUMBER_LIMIT){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
    }
    public void validateNumberInRange(List<Integer> number){
        for(Integer num : number){
            if(num<1||num>9){
                throw new IllegalArgumentException(USER_INPUT_ERROR);
            }
        }
    }
}
