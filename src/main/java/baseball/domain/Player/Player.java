package baseball.domain.Player;

import static baseball.StringEnum.InputExceptionCode.*;

import baseball.domain.Validation.InputValidation;
import baseball.domain.Validation.Restart;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> ballNumbers;

    public Player() {
        ballNumbers = new ArrayList<>();
    }

    public void readBallNumberInput(String inputString) {
        validateBallInput(inputString);
    }

    public boolean readRestartInput(String inputString) {
        return validateRestartInput(inputString);
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    private void validateBallInput(String inputString) {
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

    private boolean validateRestartInput(String inputString) {
        int restart;
        try {
            restart = Integer.parseInt(inputString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_RESTART_NUMBER.getCode());
        }
        return isRestart(restart);
    }

    private boolean isRestart(int restart) {
        Boolean isRestart = Restart.isRestart(restart);
        if (isRestart == null) {
            throw new IllegalArgumentException(NOT_RESTART_NUMBER.getCode());
        }
        return isRestart;
    }

    private void generateNumberList(String inputString) {
        ballNumbers.clear();
        for (char input : inputString.toCharArray()) {
            int number = input - '0';
            ballNumbers.add(number);
        }
    }

}
