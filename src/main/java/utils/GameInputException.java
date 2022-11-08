package utils;


import java.util.HashSet;
import java.util.Set;

public class GameInputException {
    int numberLength;

    public GameInputException() {
        this(3);
    }

    public GameInputException(int numberLength) {
        this.numberLength = numberLength;
    }

    public void checkUserInput(String userInput) throws IllegalArgumentException {
        checkNumberLength(userInput);
        checkOneToNine(userInput);
        checkUniqueNumbers(userInput);
    }

    private void checkNumberLength(String userInput) throws IllegalArgumentException{
        if (userInput.length() == numberLength) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkOneToNine(String userInput) throws IllegalArgumentException {
        for (int stringIndex = 0; stringIndex < numberLength; stringIndex++) {
            checkAllowedCharacter(userInput.charAt(stringIndex));
        }
    }

    private void checkAllowedCharacter(char userInputPart) throws IllegalArgumentException {
        int ascii = (int) userInputPart;
        if (ascii >= '1' && ascii <= '9') {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void checkUniqueNumbers(String userInput) throws IllegalArgumentException {
        Set<Character> sizeChecker = new HashSet<>();

        for (int stringIndex = 0; stringIndex < numberLength; stringIndex++) {
            sizeChecker.add(userInput.charAt(stringIndex));
        }

        if (sizeChecker.size() != numberLength) {
            throw new IllegalArgumentException();
        }
    }
}
