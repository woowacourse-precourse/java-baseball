package baseball.model;

import baseball.utils.GameNumberGenerator;
import baseball.utils.InputNumberValidator;

import java.util.Set;

public class NumberBaseBallGame {
    private InputNumberValidator inputNumberValidator;
    private Set<Integer> gameNumber;
    private boolean isProceeding;

    public NumberBaseBallGame() {
        this.inputNumberValidator = new InputNumberValidator();
        this.gameNumber = GameNumberGenerator.generate();
        this.isProceeding = true;
    }

    public boolean isProceeding() {
        return this.isProceeding;
    }

    public void validateInputNumber(String inputNumber){
        inputNumberValidator.validate(inputNumber);
    }
}
