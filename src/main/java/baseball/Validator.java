package baseball;

import static baseball.Constants.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Validator {
    /**
     * 세자리 이상일 때
     */
    public void validateInputRange(String userInput) {
        String[] input = userInput.split("");
        if (input.length != 3) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }

    /**
     * 입력받은 수에 0이 포함되어 있을 시
     * @return "INPUT_ERROR"
     */
    public void validateContainZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }
    public void checkDuplicatedNumber (String userInput) {
        Set<String> userInputList = new HashSet<>(List.of(userInput.split("")));
        if (userInputList.size() != RESULT_SIZE) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }
}
