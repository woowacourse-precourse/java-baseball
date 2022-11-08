package baseball;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class IllegalArgument {

    protected List<Integer> validatedNumber;

    public void check(String[] userInput, int argumentLength, List<Integer> possibleNumber) {
        isNumber(userInput);
        isAnswerLength(argumentLength);
        isAllUnique();
        isPossibleNumber(possibleNumber);
    }


    private void isNumber(String[] userInput) {

        List<Integer> inputNumber = new ArrayList<>();
        try {
            for (String input : userInput) {
                inputNumber.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        validatedNumber = inputNumber;
    }

    private void isAnswerLength(int argumentLength) {
        if (validatedNumber.size() != argumentLength) {
            throw new IllegalArgumentException();
        }
    }

    private void isAllUnique() {
        Set<Integer> uniqueNumber = new HashSet<>(validatedNumber);
        if (validatedNumber.size() != uniqueNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void isPossibleNumber(List<Integer> possibleNumber) {
        validatedNumber.removeAll(possibleNumber);
        if (validatedNumber.size() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
