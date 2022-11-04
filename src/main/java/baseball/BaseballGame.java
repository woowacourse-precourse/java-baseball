package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    public List<Integer> checkUserNumber(String userInput) throws IllegalArgumentException {
        if (illegalInput(userInput)) {
            throw new IllegalArgumentException();
        }
        return toIntList(userInput);
    }

    private boolean illegalInput(String userInput) {
        if (userInput.length() != 3) {
            return true;
        }
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (!Character.isDigit(c) || Character.getNumericValue(c) == 0) {
                return true;
            }
            int number = Character.getNumericValue(c);
            if (duplicateCheckSet.contains(number)) {
                return true;
            }
            duplicateCheckSet.add(number);
        }
        return false;
    }

    private List<Integer> toIntList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            user.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return user;
    }
}
