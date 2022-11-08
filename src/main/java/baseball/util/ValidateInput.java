package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ValidateInput {

    public List<Integer> validateInput(String input) {

        List<Integer> inputList = inputToList(input);
        return inputList;
    }



    public List<Integer> inputToList(String input) {

        List<Integer> intList = new ArrayList<>();
        intList.add(input.charAt(0) - '0');
        intList.add(input.charAt(1) - '0');
        intList.add(input.charAt(2) - '0');
        return intList;
    }

}
