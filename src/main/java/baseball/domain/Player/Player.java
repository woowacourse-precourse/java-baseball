package baseball.domain.Player;

import baseball.domain.Validation.InputValidation;
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
        InputValidation.validateBallInputFormat(inputString);

        generateNumberList(inputString);

        InputValidation.validateBallInputNumber(ballNumbers);
    }

    private boolean validateRestartInput(String inputString) {
        InputValidation.validateRestartInput(inputString);
        return InputValidation.validateIsRestart(Integer.parseInt(inputString));
    }

    private void generateNumberList(String inputString) {
        ballNumbers.clear();
        for (char input : inputString.toCharArray()) {
            ballNumbers.add(input - '0');
        }
    }

}
