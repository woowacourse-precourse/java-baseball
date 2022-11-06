package baseball.input;

import baseball.validatioon.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> getNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = getUserInput();
        Validation.validateSize(input,3);

        for (int index = 0; index < 3; index++) {
            int indexInt = charToInt(input.charAt(index));
            Validation.validateNumber(indexInt,lst);
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
        Validation.validateSize(userInput, 1);
        int userInputNumber = charToInt(userInput.charAt(0));
        Validation.validateOption(userInputNumber);
        return userInputNumber;
    }
}
