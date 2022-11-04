package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballException {

    public static void InputLengthException(String input) {
        List<String> inputList = new ArrayList<>();

        inputList = Arrays.asList(input.split(""));

        if (inputList.size() != 3) {
            throw new IllegalArgumentException("입려된 값의 길이가 3이 아닙니다.");
        }
    }
}
