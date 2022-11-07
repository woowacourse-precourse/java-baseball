package baseball.model;

import baseball.controller.NumberValidator;

public class GameNumber {
    private String inputString;
    private int[] playerNumbers;
    NumberValidator numberValidator = new NumberValidator();

    public void setInputString(String inputString) {
        this.inputString = inputString;
        setPlayerNumbers();
    }

    public String getInputString() {
        return inputString;
    }

    public void setPlayerNumbers() {
        playerNumbers = numberValidator.toValidateData(inputString);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}
