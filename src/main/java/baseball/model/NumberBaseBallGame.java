package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.resources.GameConfig.RESTART;
import static baseball.utils.GameNumberGenerator.generate;
import static baseball.utils.InputNumberValidator.validate;

public class NumberBaseBallGame {
    private GameNumber gameNumber;
    private boolean isProceeding;

    public NumberBaseBallGame(GameNumber gameNumber) {
        this.gameNumber = gameNumber;
        this.isProceeding = true;
    }

    public void validateInputNumber(String inputNumber) {
        validate(inputNumber);
    }

    public Result result(String inputNumber) {
        String[] inputNumbers = inputNumber.split("");
        List<Numbers> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers.add(new Numbers(i, Integer.parseInt(inputNumbers[i])));
        }
        return new Result(numbers, gameNumber);
    }

    public boolean isProceeding() {
        return isProceeding;
    }

    public void end() {
        isProceeding = false;
    }

    public void restart(String restart) {
        if (restart.equals(RESTART)) {
            isProceeding = true;
            gameNumber = generate();
        }
    }
}
