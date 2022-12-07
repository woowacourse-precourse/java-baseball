package baseball.model;

import baseball.utils.Exception;
import baseball.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final String playerNumbers;
    private InputView inputView;
    private Exception exception;
    private final List<Integer> playerNumbersList;

    public Player() {
        this.playerNumbers = setPlayerInput();
        this.playerNumbersList = setPlayerNumberList(this.playerNumbers);
        this.inputView = new InputView();
        this.exception = new Exception();
    }

    public List<Integer> getPlayerNumbersList() {
        return playerNumbersList;
    }

    private String setPlayerInput() {
        String userInput = inputView.inputNumbers();
        printInputNumber(userInput);
        return userInput;
    }

    private void printInputNumber(String userInput) {
        System.out.println(userInput);
    }

    private List<Integer> setPlayerNumberList(String inputNumber) {
        List<Integer> inputNumberList = Arrays.stream(inputNumber.split("", inputNumber.length()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        exception.checkInputNumbers(inputNumberList);
        return inputNumberList;
    }
}