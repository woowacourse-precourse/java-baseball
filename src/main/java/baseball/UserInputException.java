package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputException {
    static public boolean isContainLetter(String input) {
        for (char eachChar : input.toCharArray()) {
            if (Character.isLetter(eachChar)) {
                return true;
            }
        }
        return false;
    }

    static public boolean isInputLength(String input, int length) {
        return input.length() == length;
    }

    static public boolean hasSameNumberInList(List<Integer> input) {
        Set<Integer> removeDuplicate = new HashSet<>(input);
        return removeDuplicate.size() != input.size();
    }

    static public boolean isIllegalChoice(String choice) {
        return !choice.equals("1") && !choice.equals("2");
    }

}
