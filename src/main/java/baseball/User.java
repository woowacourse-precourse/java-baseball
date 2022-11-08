package baseball;

import java.util.HashSet;
import java.util.Set;

public class User {
    final int INPUT_NUMBER_LENGTH = 3;
    private String inputNumber;

    public User () {
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void checkInputFormat(String input) throws IllegalArgumentException {
        if(input.length() != INPUT_NUMBER_LENGTH)
            throw new IllegalArgumentException();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            isDigit(c);
        }

        isDuplicated(input);
    }

    private void isDigit(char c) throws IllegalArgumentException {
        if(!Character.isDigit(c))
            throw new IllegalArgumentException();
        if(c < '1' || c > '9')
            throw new IllegalArgumentException();
    }

    private void isDuplicated(String input) throws IllegalArgumentException {
        Set<Character> inputSet = new HashSet<>();

        for(int i=0; i<input.length(); i++) {
            inputSet.add(input.charAt(i));
        }
        if(inputSet.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    public String getInputNumber() {
        return inputNumber;
    }
}
