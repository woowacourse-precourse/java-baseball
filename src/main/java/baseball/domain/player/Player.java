package baseball.domain.player;

import baseball.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> inputNumbers;

    public Player() {
        this.inputNumbers = new ArrayList<>();
    }

    public void setInputNumbers(String input) {
        Validator.validateNumberInput(input);
        this.inputNumbers = convertToInteger(input);
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    private List<Integer> convertToInteger(String inputNumber) {
        List<String> inputNumbersStr = new ArrayList<>(List.of(inputNumber.split("")));
        List<Integer> inputNumbersInt = new ArrayList<>();

        inputNumbersStr.forEach(n -> inputNumbersInt.add(Integer.parseInt(n)));

        return inputNumbersInt;
    }
}
