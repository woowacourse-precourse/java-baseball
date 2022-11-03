package baseball.model;

import baseball.utils.GameNumberGenerator;
import baseball.utils.InputNumberValidator;

import java.util.ArrayList;
import java.util.List;

import static baseball.resources.GameConfig.RESTART;

public class NumberBaseBallGame {
    private final InputNumberValidator inputNumberValidator;
    private List<Integer> gameNumber;
    private boolean isProceeding;

    public NumberBaseBallGame(List<Integer> gameNumber) {
        this.inputNumberValidator = new InputNumberValidator();
        this.gameNumber = gameNumber;
        this.isProceeding = true;
    }

    public boolean isProceeding() {
        return this.isProceeding;
    }

    public void validateInputNumber(String inputNumber) {
        inputNumberValidator.validate(inputNumber);
    }

    public Result result(String inputNumber) {
        String[] inputNumbers = inputNumber.split("");
        List<Numbers> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers.add(new Numbers(i, Integer.parseInt(inputNumbers[i])));
        }
        return new Result(numbers, gameNumber);
    }

    public void end() {
        isProceeding = false;
    }

    public void restart(String restart) {
        if (restart.equals(RESTART)) {
            this.isProceeding = true;
            gameNumber = GameNumberGenerator.generate();
        }
    }
}
