package baseball.model;

import java.util.List;

public class GameNumber {
    private String playerInput;
    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public void setPlayerInput(String inputString) {
        this.playerInput = inputString.replaceAll(" ", "");
    }

    public String getPlayerInput() {
        return playerInput;
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
