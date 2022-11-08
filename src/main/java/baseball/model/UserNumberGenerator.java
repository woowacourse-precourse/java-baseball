package baseball.model;

import baseball.view.InputView;

import java.util.List;

public class UserNumberGenerator {

    public final List<Integer> VALIDATED_NUM;

    public UserNumberGenerator() {
        this.VALIDATED_NUM = generateUserNum();
    }

    private static List<Integer> generateUserNum() throws IllegalArgumentException {
        String startInput = InputView.gameEndInput();
        List<Integer> numbers = NumberValidator.convertStringToList(startInput);
        if (isValid(numbers))
            return numbers;
        throw new IllegalArgumentException();

    }
}
