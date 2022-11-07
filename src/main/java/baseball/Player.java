package baseball;

import baseball.inputException.ContainingZeroException;
import baseball.inputException.DuplicatedNumberException;
import baseball.inputException.IllegalDigitsException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerNumber;

    public void receiveInput() {
        this.playerNumber = getUserInputValue();
    }

    List<Integer> getUserInputValue() {

        List<Integer> userInput = new ArrayList<>();
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            userInput.add(input.charAt(i) - '0');
        }

        if (userInput.size() != 3)
            throw new IllegalDigitsException();
        if (!confirmDuplicationNumber(userInput))
            throw new DuplicatedNumberException();
        if (isContainingZero(userInput))
            throw new ContainingZeroException();

        return userInput;
    }

    boolean confirmDuplicationNumber(List<Integer> number) {
        return (number.get(0) != number.get(1)) && (number.get(1) != number.get(2)) && (number.get(0) != number.get(2));
    }

    boolean isContainingZero(List<Integer> number) {
        return (number.contains(0));
    }
}
