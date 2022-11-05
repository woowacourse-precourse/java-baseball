package baseball.domain.Player;

import static baseball.StringEnum.InputExceptionCode.*;

import baseball.domain.Validation.InputValidation;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> ballNumbers;

    public Player() {
    }

    public void readPlayerNumberInput() {
        String inputString = Console.readLine();
        validateInput(inputString);
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    private void validateInput(String inputString) {
        if (!InputValidation.hasOnlyNumbers(inputString)) {
            throw new IllegalArgumentException(NOT_NUMBER_INCLUDE.getCode());
        }

        if (!InputValidation.is3Numbers(inputString)) {
            throw new IllegalArgumentException(NOT_3_NUMBERS.getCode());
        }

        generateNumberList(inputString);

        if (!InputValidation.isInRange(ballNumbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getCode());
        }

        if (!InputValidation.isNotDuplicate(ballNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getCode());
        }
    }

    private void generateNumberList(String inputString) {
        for (char input : inputString.toCharArray()) {
            int number = input - '0';
            ballNumbers.add(number);
        }
    }

}
