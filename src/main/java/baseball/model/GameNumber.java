package baseball.model;

import baseball.controller.NumberValidator;
import baseball.controller.RandomUtility;

import java.util.Arrays;

public class GameNumber {
    private String inputString;
    private int[] playerNumbers;
    private int[] computerNumbers;

    public void setInputString(String inputString) {
        this.inputString = inputString.replaceAll(" ", "");
    }

    public String getInputString() {
        return inputString;
    }

    public void setPlayerNumbers(int[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }

    public void setComputerNumbers(int[] computerNumbers) {
        this.computerNumbers = computerNumbers;
        System.out.println("computerNumbers" + Arrays.toString(computerNumbers));
    }

    public int[] getComputerNumbers() {
        return computerNumbers;
    }
}
