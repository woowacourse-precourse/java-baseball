package baseball.valid;

import baseball.util.message.ExceptionMessage;
import baseball.util.constant.GameNumberConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumberValidator implements InputValidator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<Integer> numbers = convertInputToNumbers(input);
        if (!hasCorrectSize(numbers)
                || !inRange(numbers)
                || !isDistinct(numbers)) {
            String message = ExceptionMessage.READ_INVALID_PLAYER_NUMBER_ERROR.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == GameNumberConst.NUMBER_SIZE;
    }

    private boolean inRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number ->
                        number >= GameNumberConst.MIN_NUMBER && number <= GameNumberConst.MAX_NUMBER);
    }

    private boolean isDistinct(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();

        return numbers.size() == distinctSize;
    }

    private List<Integer> convertInputToNumbers(String input) throws IllegalArgumentException {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
