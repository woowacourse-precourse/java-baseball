package baseball;

import constant.GameConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballException {

    public static void InputLengthException(String input) {
        List<String> inputList = new ArrayList<>();

        inputList = Arrays.asList(input.split(""));

        if (inputList.size() != 3) {
            throw new IllegalArgumentException(GameConstant.INPUT_LENGTH_EXCEPTION);
        }
    }
}
