package baseball.input;

import baseball.validatioon.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.NUMBER_LENGTH;
import static baseball.Constants.OPTION_NUMBER_LENGTH;

public class UserInput {

    public List<Integer> getNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = getUserInput();
        Validation.validateSize(input,NUMBER_LENGTH);

        for (int index = 0; index < NUMBER_LENGTH; index++) {
            int indexInt = charToInt(input.charAt(index));
            Validation.validateNumber(indexInt, lst);
            lst.add(indexInt);
        }
        return lst;
    }

    private String getUserInput(){
        return Console.readLine();
    }

    private int charToInt(char c) {
        Validation.validateCharIsDigit(c);
        return c - '0';
    }

    public int getRestartOption(){
        String userInput = getUserInput();
        Validation.validateSize(userInput, OPTION_NUMBER_LENGTH);
        int userInputNumber = charToInt(userInput.charAt(0));
        Validation.validateOption(userInputNumber);
        return userInputNumber;
    }
}
