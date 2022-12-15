package baseball.model;

import baseball.utils.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private Exception exception;
    private List<Integer> playerNumbers;

    public Player() {
        this.playerNumbers = new ArrayList<>();
        this.exception = new Exception();
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
    public void setNumbers(String userInput){
        exception.checkInputNumbers(userInput);
        playerNumbers = setPlayerNumbers(userInput);
    }

    private List<Integer> setPlayerNumbers(String inputNumber) {
        List<Integer> inputNumbers = Arrays.stream(inputNumber.split("", inputNumber.length()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputNumbers;
    }
}