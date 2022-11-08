package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    List<Integer> numbersPickedByComputer;

    public void computerSelectThreeNumbers() {
        numbersPickedByComputer = new ArrayList<>();
        while (numbersPickedByComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbersPickedByComputer.contains(randomNumber)) {
                numbersPickedByComputer.add(randomNumber);
            }
        }
    }

    public void validateInputNumber(String numberString) throws IllegalArgumentException {
        if (!validateLengthOfInputString((numberString)) ||
                !validateTypeOfInputString(numberString) ||
                !validateUniquenessOfEachCharacter(numberString)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateLengthOfInputString(String numberString) {
        if (numberString.length() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateTypeOfInputString(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            char numberCharacter = numberString.charAt(i);
            if (numberCharacter < '1' || numberCharacter > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean validateUniquenessOfEachCharacter(String numberString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < numberString.length(); i++) {
            char numberCharacter = numberString.charAt(i);
            if (set.contains(numberCharacter)) {
                return false;
            } else {
                set.add(numberCharacter);
            }
        }
        return true;
    }


}
