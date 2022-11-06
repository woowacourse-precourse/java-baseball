package baseball.gameComponents;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubUtils {

    public void validateNumber(List<Integer> number) {
        if(number.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
        for(Integer n : number) {
            if(n <= 0 || n > 9) {
                throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
            }
        }
        Set<Integer> set = new HashSet<>(number);
        if(set.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
    }

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new GameException(ExceptionCode.INPUT_NOT_VALID);
        }
    }


    public List<Integer> convertStringToList(String input) {
        List<Integer> list = Arrays.asList(input.split("")).stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed()
                .collect(Collectors.toList());
        return list;
    }
}
