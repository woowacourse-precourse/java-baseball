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

    public static void InputTypeBoundaryException(String input) {

        for (char letter : input.toCharArray()) {
            if (letter < 48 || letter > 57) {
                throw new IllegalArgumentException(GameConstant.INPUT_TYPE_EXCEPTION);
            }
            if (letter == 48) {
                throw new IllegalArgumentException(GameConstant.INPUT_BOUNDARY_EXCEPTION);
            }
        }
    }

    public static void InputRepeatException(String input) {
        List<Character> confirm = new ArrayList<>();

        for (char letter : input.toCharArray()) {
            if (confirm.contains(letter)) {
                throw new IllegalArgumentException(GameConstant.INPUT_REPEAT_EXCEPTION);
            }
            confirm.add(letter);
        }

    }
}
