package baseball;

import baseball.inputException.ContainingZeroException;
import baseball.inputException.DuplicatedNumberException;
import baseball.inputException.IllegalDigitsException;
import baseball.inputException.InvalidNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.inputException.ContainingZeroException.isContainingZero;
import static baseball.inputException.DuplicatedNumberException.confirmDuplicationNumber;

public class Player {
    List<Integer> playerNumber;

    public void receiveInput() {
        this.playerNumber = getUserInputValue();
    }

    List<Integer> getUserInputValue() {

        List<Integer> userInput = new ArrayList<>();
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new InvalidNumberException();
            }
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


}
