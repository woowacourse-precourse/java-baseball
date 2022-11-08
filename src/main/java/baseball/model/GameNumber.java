package baseball.model;

import baseball.controller.NumberValidator;
import baseball.controller.RandomUtility;

import java.util.Arrays;
import java.util.List;

public class GameNumber {
    private String inputString;
    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public void setInputString(String inputString) {
        this.inputString = inputString.replaceAll(" ", "");
    }

    public String getInputString() {
        return inputString;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
