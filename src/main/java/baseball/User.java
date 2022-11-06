package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.Constant.*;

public class User {

    public String inputNumber() {
        System.out.println(INPUT_SENTENCE);
        String input = Console.readLine();
        isValidInput(input);
        return input;
    }

    public void isValidInput(String input) throws IllegalArgumentException {
        if (!(isDigitInput(input) && isInputLengthThree(input)))
            throw new IllegalArgumentException();
    }

    private boolean isDigitInput(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isInputLengthThree(String input) throws IllegalArgumentException {
        if (input.length() != CNT_NUMBER)
            throw new IllegalArgumentException();
        return true;
    }
}
