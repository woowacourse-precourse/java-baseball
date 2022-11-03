package baseball.application;

import baseball.model.BaseNumber;
import baseball.model.InputNumber;
import baseball.model.Result;

import java.util.ArrayList;
import java.util.List;

import static baseball.resources.GameConfig.RESTART;
import static baseball.utils.GameNumberGenerator.generate;
import static baseball.utils.InputValidator.validate;

public class NumberBaseBallGame {
    private BaseNumber baseNumber;
    private boolean isProceeding;

    public NumberBaseBallGame(BaseNumber gameNumber) {
        this.baseNumber = gameNumber;
        this.isProceeding = true;
    }

    public void validateInputNumber(String input) {
        validate(input);
    }

    public Result result(String input) {
        String[] inputs = input.split("");
        List<InputNumber> inputNumber = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            inputNumber.add(new InputNumber(i, Integer.parseInt(inputs[i])));
        }
        return new Result(inputNumber, baseNumber);
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
            baseNumber = generate();
        }
    }
}
