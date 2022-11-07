package baseball;

import java.util.HashSet;

public class InputValidation {

    public String validateInput(String userInput) {

        if (!userInput.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        } else if (!inputNumberNotSame(userInput)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public boolean inputNumberNotSame(String userInput) {

        boolean inputNumberOk = true;
        HashSet<Integer> inputNumberSet = new HashSet<>();

        for (int i = 0; i < userInput.length(); i++) {
            inputNumberSet.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }
        if (inputNumberSet.size() != 3) {
            inputNumberOk = false;
        }

        return inputNumberOk;
    }

}
