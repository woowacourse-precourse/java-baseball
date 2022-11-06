package baseball;

import static baseball.Constants.*;

import java.util.HashSet;
import java.util.Set;


public class Validator {
    public void validateInputRange(int userInput) {
        if (userInput < MIN_ACCESS_INPUT_NUMBER || userInput > MAX_ACCESS_INPUT_NUMBER) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }
    public void validateContainZero(int userInput) {
        if (userInput % 100 < 10 || userInput % 10 == 0) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }
    public void checkDuplicatedNumber (int userInput) {
        Set<Integer> userInputList = new HashSet<>();
        userInputList.add(userInput / 100);
        userInputList.add(userInput % 100 / 10);
        userInputList.add(userInput % 10);

        if (userInputList.size() != RESULT_SIZE) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
    }
}
