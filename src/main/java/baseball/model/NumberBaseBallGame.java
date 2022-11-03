package baseball.model;

import baseball.utils.InputNumberValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberBaseBallGame {
    private InputNumberValidator inputNumberValidator;
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

    public void validateInputNumber(String inputNumber){
        inputNumberValidator.validate(inputNumber);
    }

    public Map<String, Integer> checkResultPoint(String inputValue){
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
