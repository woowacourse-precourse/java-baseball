package baseball.model;

import baseball.utils.GameNumberGenerator;
import baseball.utils.InputNumberValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Deprecated
    public Map<String, Integer> checkResultPoint(String inputValue) {
        String[] numbers = inputValue.split("");
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = Integer.parseInt(numbers[i]);
            if (gameNumber.contains(currentNumber) && gameNumber.get(i) == currentNumber) {
                result.put("strike", result.getOrDefault("strike", 0) + 1);
                continue;
            }
            if (gameNumber.contains(currentNumber)) {
                result.put("ball", result.getOrDefault("ball", 0) + 1);
            }
        }
        return result;
    }
}
