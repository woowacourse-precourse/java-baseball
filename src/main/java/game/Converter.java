package game;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> convertToList(String userInput, int length) throws IllegalArgumentException {
        List<Integer> userInputList = new ArrayList<>();
        if (isAppropriateLength(userInput, length) && isAppropriateRange(userInput)
                && isUniqueInput(userInput)) {
            for (int i = 0; i < userInput.length(); i++) {
                userInputList.add(charToInt(userInput.charAt(i)));
            }
        }
        return userInputList;
    }

    private boolean isAppropriateLength(String userInput, int length) throws IllegalArgumentException {
        if (userInput.length() == length) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean isAppropriateRange(String userInput) throws IllegalArgumentException {
        for (int i = 0; i < userInput.length(); i++) {
            int userInputDigit = charToInt(userInput.charAt(i));
            if ((userInputDigit < 1) || (userInputDigit > 10)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private boolean isUniqueInput(String userInput) throws IllegalArgumentException {
        int[] checkUnique = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < userInput.length(); i++) {
            int userInputDigit = charToInt(userInput.charAt(i));
            userInputDigit--;
            if (checkUnique[userInputDigit] > 0) {
                throw new IllegalArgumentException();
            }
            checkUnique[userInputDigit]++;
        }
        return true;
    }

    private int charToInt(char c) {
        int digit = Character.getNumericValue(c);
        return digit;
    }
}
