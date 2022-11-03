package utils;


import java.util.HashSet;
import java.util.Set;

public class GameInputException {
    int numberLength;

    GameInputException() {}

    GameInputException(int numberLength) {
        this.numberLength = numberLength;
    }

    public void checkUserInput(String userInput) throws IllegalArgumentException {
        checkNaturalNumber(userInput);
        checkNumberLength(userInput);
        checkContainZero(userInput);
        checkUniqueNumbers(userInput);
    }

    private void checkNumberLength(String userInput) throws IllegalArgumentException{
        if (userInput.length() == numberLength) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkNaturalNumber(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero(String userInput) throws IllegalArgumentException {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException();
        }
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
