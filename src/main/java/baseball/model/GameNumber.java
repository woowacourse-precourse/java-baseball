package baseball.model;

import baseball.controller.NumberValidator;
import baseball.controller.RandomUtility;

import java.util.Arrays;

public class GameNumber {
    private String inputString;
    private int[] playerNumbers;
    private int[] computerNumbers;
    NumberValidator numberValidator = new NumberValidator();
    RandomUtility randomUtility = new RandomUtility();

    public void setInputString(String inputString) {
        this.inputString = inputString.replaceAll(" ", "");
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

    public void setComputerNumbers() {
        computerNumbers = randomUtility.generateRandomNumbers();
        System.out.println("computerNumbers" + Arrays.toString(computerNumbers));
    }

    public int[] getComputerNumbers() {
        return computerNumbers;
    }
}
