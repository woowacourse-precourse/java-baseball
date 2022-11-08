package baseball.valid;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public void validNumbers(String readLine) {
        if (!isDigit(readLine) || readLine.length() != 3) {
            throw new IllegalArgumentException("Number is Not Valid Exception!!");
        }

        duplicatedValid(readLine);
    }

    private boolean isDigit(String readLine) {
        return readLine.chars().allMatch(Character::isDigit);
    }

    private void duplicatedValid(String readLine) {
        Set<String> set = new HashSet<>();

        for (String word : readLine.split("")) {
            if (!set.add(word)) {
                throw new IllegalArgumentException("Number is Not Valid Exception!!");
            }
        }

        set.clear();
    }

    public void restartNumberValid(String readLine) {
        if (!(Integer.valueOf(readLine).equals(1) || Integer.valueOf(readLine).equals(2))) {
            throw new IllegalArgumentException("Number is Not Valid Exception!!");
        }
    }
}
