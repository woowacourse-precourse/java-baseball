package baseball.model;

import baseball.view.UserInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class OffenseNumberGenerator {
    private UserInput userInput;

    public OffenseNumberGenerator() {
        userInput = new UserInput();
    }

    public List<Integer> generateOffenseNumbers() {
        String input = userInput.input();
        List<Integer> unvalidatedNumbers = Utils.convertStringToIntegerList(input);
        // TODO: 사용자의 입력 값이 적합한지 검증한다.
        return null;
    }
}
