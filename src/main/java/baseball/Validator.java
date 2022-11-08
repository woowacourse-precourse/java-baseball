package baseball;

import static baseball.View.Constant.MAX_LENGTH;

public class Validator {
    public void isNumeric(String input) throws IllegalArgumentException {
        try {
            Double.parseDouble(input);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("input is now numeric.");
        }
    }

    public void checkGuessLength(String input) throws IllegalArgumentException {
        if(input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("guess only 3 numbers.");
        }
    }

    public void checkRange(int input) throws IllegalArgumentException {
        if(input < 1 || input > 9 ) {
            throw new IllegalArgumentException("guess between 1 ~ 9.");
        }
    }

    public void checkFlagLength(String input) throws IllegalArgumentException {
        if(input.length() != 1) {
            throw new IllegalArgumentException("Enter 1 to RESTART the game or 2 to EXIT the game.");
        }
    }

    public void checkFlag(String flag) throws IllegalArgumentException {
        if(!flag.equals("1") && !flag.equals("2")) {
            throw new IllegalArgumentException("Enter 1 to RESTART the game or 2 to EXIT the game.");
        }
    }

    //todo 각 자리의 수가 서로 다른 숫자인지 확인
}
