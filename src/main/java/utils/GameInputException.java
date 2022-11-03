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
}
