package baseball.model;

import baseball.view.InputView;

import java.util.List;

public class UserNumberGenerator {

    public final List<Integer> VALIDATED_NUM;

    public UserNumberGenerator() {
        this.VALIDATED_NUM = generateUserNum();
    }

    private static List<Integer> generateUserNum() throws IllegalArgumentException {
        String startInput = InputView.gameStartInput();
        List<Integer> numbers = NumberValidator.convertStringToList(startInput);
        System.out.println("numbers = " + numbers);
        if (isValid(numbers))
            return numbers;
        throw new IllegalArgumentException();

    }

    private static boolean isValid(List<Integer> numbers) {
        return numbers.size() == ValidateNumber.NUMBER_LENGTH.getNumber()
                && NumberValidator.isValidRange(numbers)
                && NumberValidator.checkIfIsNotDuplicatedNum(numbers);
    }
}
