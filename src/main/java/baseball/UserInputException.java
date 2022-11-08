package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputException {
    public static boolean isContainLetter(String input) {
        return input.chars()
                .anyMatch(each -> Character.isLetter(each));
    }

    public static boolean isInputLength(String input, int length) {
        return input.length() == length;
    }

    public static boolean hasSameNumberInList(List<Integer> input) {
        Set<Integer> removeDuplicate = new HashSet<>(input);
        return removeDuplicate.size() != input.size();
    }

    public static boolean isIllegalChoice(String choice) {
        return !choice.equals("1") && !choice.equals("2");
    }

}
