package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final String playerNumbers;
    private final List<Integer> playerNumbersList;
    public Player() {
        this.playerNumbers = inputNumbers();
        this.playerNumbersList =setPlayerNumberList(this.playerNumbers);
    }
    public String inputNumbers() {
        String userInput = Console.readLine();
        System.out.println(userInput);
        return userInput;
    }
    private List<Integer> setPlayerNumberList(String inputNumber) {
        List<Integer> inputNumberList = Arrays.stream(inputNumber.split("",inputNumber.length()))
                .map(Integer::parseInt).collect(Collectors.toList());
        Exception.checkInputNumbers(inputNumberList);
        return inputNumberList;
    }
    public List<Integer> getPlayerNumbersList(){
        return playerNumbersList;
    }

}
