package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean isGameEnd = false;

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        isGameEnd = gameEnd;
    }

    public static boolean isNumeric(String userInput) {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void checkValidNumber(String userInput) {
        if (userInput.length() != 3 || !isNumeric(userInput)) {
            throw new IllegalArgumentException();
        }
        List<Integer> userInputNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Integer tempNum = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            if (tempNum.equals(0)) {
                throw new IllegalArgumentException();
            } else if (userInputNumber.contains(tempNum)) {
                throw new IllegalArgumentException();
            } else {
                userInputNumber.add(tempNum);
            }
        }
    }

}
