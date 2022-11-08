package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.Constant.*;

public class User {

    private String userNumber;

    public String getUserNumber() {
        return userNumber;
    }

    public void inputNumber() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();
        isValidInput(input);
        this.userNumber = input;
    }

    public void isValidInput(String input) throws IllegalArgumentException {
        if (!(isDigitInput(input) && isInputLengthThree(input) && isDuplicateInput(input) && isRangeInput(input)))
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

    private boolean isDuplicateInput(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length())
            throw new IllegalArgumentException();
        return true;
    }

    private boolean isRangeInput(String input) throws IllegalArgumentException {
        Pattern numberPattern = Pattern.compile(REGAX);
        if (!numberPattern.matcher(input).matches())
            throw new IllegalArgumentException();
        return true;
    }
}
