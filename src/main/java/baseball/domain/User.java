package baseball.domain;

import baseball.utils.NumberValidator;
import baseball.status.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class User {

    private String input;
    private List<Integer> userNumbers;

    public void initializeUserNumbers() {
        userNumbers = new ArrayList<>();
    }

    public void processUserInput() {
        input = Console.readLine();
        NumberValidator.validate(input);
        parseUserInput();
    }

    private void parseUserInput() {
        IntStream.range(Constants.ZERO_COUNT.getNumber(), Constants.NUMBER_OF_DIGITS.getNumber())
                .forEach(index -> userNumbers.add(parseCharToDigit(input.charAt(index))));
    }

    public int parseCharToDigit(char charDigit) {
        return charDigit - Constants.FIRST_CHARACTER_OF_DIGITS.getNumber();
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void updateUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }
}
