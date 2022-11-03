package baseball;

import java.util.Arrays;
import java.util.List;

public class InputValueValidation {

    public boolean isValid(String inputValue) {
        if(isNumber(inputValue) && isLengthThree(inputValue) && noDuplicates(inputValue)) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(num -> num >= '1' && num <= '9');
    }

    public boolean isLengthThree(String inputValue) {
        return inputValue.length() == 3;
    }

    public boolean noDuplicates(String inputValue) {
        List<String> arrayInputValue = Arrays.asList(inputValue.split(""));
        return arrayInputValue.stream().distinct().count() == 3;
    }
}
