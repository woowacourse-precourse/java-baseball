package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> stringToInt(String input,List<Character> inputList) {
        for (char x : input.toCharArray()) {
            Validation.validateArguments(x,inputList);
            inputList.add(x);
        }
        return charToInt(inputList);
    }

    public static List<Integer> charToInt(List<Character> userInput) {
        List<Integer> result = new ArrayList<>();
        for (char x : userInput) {
            result.add(Integer.parseInt(String.valueOf(x)));
        }
        return result;
    }
}
