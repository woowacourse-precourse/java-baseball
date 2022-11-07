package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    private String readLine;

    public Validation(String readLine) {
        this.readLine = readLine;
        validNumbers();
    }

    private void validNumbers() {
        if (!isDigit() || readLine.length() != 3) {
            throw new IllegalArgumentException("Number is Not Valid Exception!!");
        }

        duplicatedValid();
    }

    private boolean isDigit() {
        return this.readLine.chars().allMatch(Character::isDigit);
    }

    private void duplicatedValid() {
        Set<String> set = new HashSet<>();

        for (String word : readLine.split("")) {
            if (!set.add(word)) {
                throw new IllegalArgumentException("Number is Not Valid Exception!!");
            }
        }

        set.clear();
    }


}
