package baseball.view.validation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputValidation{

    public void validStartOrEndNumber(String readLine) {
        if (isDigit(readLine) && !isBlank(readLine)) {
            if (isNumberRange(Integer.parseInt(readLine))) {
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    public void validDuplicateNumber(String readLine) {
        if (isDigit(readLine) && !isBlank(readLine)) {
            int size = Arrays.stream(readLine.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet())
                    .size();

            if (size == 3) {
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    private boolean isDigit(String readLine) {
        return readLine.chars().allMatch(Character::isDigit);
    }

    private boolean isBlank(String readLine) {
        return readLine.chars().anyMatch(value -> value == ' ');
    }

    private boolean isNumberRange(int number) {
        if (number == 1 || number == 2) {
            return true;
        }

        return false;
    }
}
