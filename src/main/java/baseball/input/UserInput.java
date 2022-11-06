package baseball.input;

import baseball.validatioon.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> getNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = getUserInput();

        if (!Validation.isValidSize(input)) {
            throw new IllegalArgumentException();
        }

        for (int index = 0; index < 3; index++) {
            int indexInt = charToInt(input.charAt(index));
            if (!Validation.isValidNumber(indexInt, lst)) {
                throw new IllegalArgumentException();
            }
            lst.add(indexInt);
        }
        return lst;
    }

    private int charToInt(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        return c - '0';
    }
    private String getUserInput(){
        return Console.readLine();
    }
}
