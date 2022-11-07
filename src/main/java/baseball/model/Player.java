package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    public void setPlayerNumbers(String inputNumber) {
        this.playerNumbers = toIntegerList(inputNumber);
    }

    public List<Integer> toIntegerList(String inputNumber) {
        List<Integer> playerNumber = new ArrayList<>();
        for (int i = 0; i < inputNumber.length() ; i++) {
            char tmpChar = inputNumber.charAt(i);
            Integer tmpInteger = Character.getNumericValue(tmpChar);
            playerNumber.add(tmpInteger);
        }
        return playerNumber;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}