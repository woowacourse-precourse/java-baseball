package baseball.model;

import baseball.utils.Exception;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private InputView inputView;
    private Exception exception;
    private List<Integer> playerNumbers;

    public Player() {
        this.playerNumbers = new ArrayList<>();
        this.inputView = new InputView();
        this.exception = new Exception();
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
    public void setNumbers(){
        String input = setPlayerInput();
        playerNumbers = setPlayerNumbers(input);
    }
    private String setPlayerInput() {
        String userInput = inputView.inputNumbers();
        inputView.printInputNumber(userInput);
        exception.checkInputNumbers(userInput);
        return userInput;
    }

    private List<Integer> setPlayerNumbers(String inputNumber) {
        List<Integer> inputNumbers = Arrays.stream(inputNumber.split("", inputNumber.length()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputNumbers;
    }
}