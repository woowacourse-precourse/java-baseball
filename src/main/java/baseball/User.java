package baseball;

import java.util.HashSet;

public class User {
    private static final int NumberLength = 3;
    private static String userNumber;

    User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber() {
        userNumber = Input.getInput();
        inputValidation(userNumber);
    }

    public boolean checkNumLength(String num) {
        return num.length() == NumberLength;
    }

    public boolean checkNumFormat(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean checkNumDuplication(String num) {
        HashSet<Integer> checkEqualHashSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            checkEqualHashSet.add(num.charAt(i) - '0');
        }
        return checkEqualHashSet.size() == NumberLength;
    }

    public void inputValidation(String num) {
        if (!checkNumFormat(num) || !checkNumLength(num) || !checkNumDuplication(num)) {
            throw new IllegalArgumentException();
        }
    }

}
