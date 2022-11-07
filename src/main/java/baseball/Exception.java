package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    private final static int USER_INPUT_NUMBER_LENGTH = 3;

    public boolean isValidLength(String userNumber) {
        return userNumber.length() == USER_INPUT_NUMBER_LENGTH;
    }

    public boolean isValidNumber(String userNumber) {
        try {
            int userRandomNumber = Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isValidDuplicate(List<Integer> numbers) {
        Set<Integer> isUsing = new HashSet<>();
        for (Integer number : numbers) {
            addNotContainNumber(isUsing, number);
        }
        return isUsing.size() == USER_INPUT_NUMBER_LENGTH;
    }

    private void addNotContainNumber(Set<Integer> isUsing, Integer number) {
        if (!isUsing.contains(number)) {
            isUsing.add(number);
        }
    }

    public boolean isValidGameMode(int method) {
        if (method == 1 || method == 2) {
            return true;
        }
        return false;
    }
}
