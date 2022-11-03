package utils;

public class GameInputException {
    int numberLength;

    GameInputException() {}

    GameInputException(int numberLength) {
        this.numberLength = numberLength;
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
}
