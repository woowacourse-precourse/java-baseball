package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static constant.Message.INPUT_ERROR_MESSAGE;

public class InputException {

    public static void outOfRange(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void repeatNumber(String input) {
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputList.add(input.split("")[i]);
        }
        if (inputList.size() != inputList.stream().distinct().count()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void excludeOneToNine(String input) {
        String validateNumber = "^[1-9]*$";
        boolean validate = Pattern.matches(validateNumber, input);
        if (!validate) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
