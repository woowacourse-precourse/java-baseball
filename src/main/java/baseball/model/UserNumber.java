package baseball.model;

import java.util.*;

public class UserNumber {
    private List<Integer> userNumbers;
    private static final int MAX_LENGTH = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int MIN_REPLAY_RANGE = 1;
    private static final int MAX_REPLAY_RANGE = 3;

    public void setUserNumbers(String input) {
        userNumbers = new ArrayList<>();
        int inputToInt = Integer.parseInt(input);

        while (inputToInt > 0) {
            userNumbers.add(inputToInt % 10);
            inputToInt /= 10;
        }
        Collections.reverse(userNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public boolean isInputDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInputUnderMaxLength(String input) {
        return input.length() == MAX_LENGTH;
    }

    public boolean isInputNotDuplicate(String input) {
        List<Character> checkInputArrayList = new ArrayList<>();
        Set<Character> checkDuplicate;

        for (int i = 0; i < input.length(); i++) {
            checkInputArrayList.add(input.charAt(i));
        }

        checkDuplicate = new HashSet<>(checkInputArrayList);

        return checkInputArrayList.size() == checkDuplicate.size();
    }

    public boolean isBetween1to9(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(Character.getNumericValue(input.charAt(i)) <= MAX_RANGE) ||
                    !(Character.getNumericValue(input.charAt(i)) >= MIN_RANGE)) {
                return false;
            }
        }
        return true;
    }

    public boolean is1or2(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(Character.getNumericValue(input.charAt(i)) < MAX_REPLAY_RANGE) ||
                    !(Character.getNumericValue(input.charAt(i)) >= MIN_REPLAY_RANGE)) {
                return false;
            }
        }
        return true;
    }
}