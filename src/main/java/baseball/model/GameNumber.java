package baseball.model;

import baseball.controller.NumberValidator;

public class GameNumber {
    private String inputString;
    NumberValidator numberValidator = new NumberValidator();

    public void setInputString(String inputString) {
        this.inputString = inputString;
        numberValidator.toValidateData(inputString);
    }

    public String getInputString() {
        return inputString;
    }
}
