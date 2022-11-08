package baseball;

import java.util.ArrayList;
import java.util.List;

public class CreateUserNumber {
    public static List<Integer> userAnswer(String inputNumber) {
        ValidCheck.numberCheck(inputNumber);
        List<String> inputArray = List.of(inputNumber.split(""));
        List<Integer> userInput = new ArrayList<>();
        for (String number : inputArray) {
            userInput.add(Integer.parseInt(number));
        }
        return userInput;
    }
}
