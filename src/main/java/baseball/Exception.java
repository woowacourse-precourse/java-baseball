package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {

    public void checkInputException(String userBaseBallNumber) {
        checkLength(userBaseBallNumber);
        checkNumberRange(userBaseBallNumber);
        checkOverLap(userBaseBallNumber);
    }

    public void checkLength(String userBaseBallNumber) throws IllegalArgumentException {
        if (userBaseBallNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberRange(String userBaseBallNumber) throws IllegalArgumentException {
        for (int i = 0; i < userBaseBallNumber.length(); i++) {
            if (!(userBaseBallNumber.charAt(i) >= '1' && userBaseBallNumber.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkOverLap(String userBaseBallNumber) throws IllegalArgumentException {

        Set<Character> overLapSet = new HashSet<>();

        for (int i = 0; i < userBaseBallNumber.length(); i++) {
            overLapSet.add(userBaseBallNumber.charAt(i));
        }

        if (overLapSet.size() != userBaseBallNumber.length()) {
            throw new IllegalArgumentException();
        }

    }

    public void checkReStarNumberRange(String reStartNumber) {
        if (!(reStartNumber.charAt(0) >= '1' && reStartNumber.charAt(0) <= '2')) {
            throw new IllegalArgumentException();
        }
    }

}
