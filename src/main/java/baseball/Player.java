package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final String playerNumbers;
    private final List<Integer> playerNumbersList;

    public Player() {
        this.playerNumbers = setPlayerInput();
        this.playerNumbersList = setPlayerNumberList(this.playerNumbers);
    }

    public List<Integer> getPlayerNumbersList() {
        return playerNumbersList;
    }

    public String inputNumbers() {
        return Console.readLine();
    }

    private String setPlayerInput() {
        String userInput = inputNumbers();
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
        Exception.checkInputNumbers(inputNumberList);
        return inputNumberList;
    }
}