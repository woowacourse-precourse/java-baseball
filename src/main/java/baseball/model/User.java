package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNumberList = new ArrayList<>();
    private static final int MAX_NUMBER_SIZE = 3;

    public void setUserNumber(String userNumber) throws IllegalArgumentException {
        for (int i = 0; i < userNumber.length(); i++) {
            int eachNumber = Integer.parseInt(String.valueOf(userNumber.charAt(i)));

            if (userNumberList.size() != MAX_NUMBER_SIZE) {
                userNumberList.add(eachNumber);
            } else {
                userNumberList.set(i, eachNumber);
            }
        }
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }


    public boolean checkDuplicateNumber(String userNumber) {
        int[] checkArray = new int[11];
        for (int i = 0; i < userNumber.length(); i++) {
            int num = Integer.parseInt(String.valueOf(userNumber.charAt(i)));
            checkArray[num]++;
        }
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean checkNumberSize(String userNumber) {
        return userNumber.length() != MAX_NUMBER_SIZE;
    }

    public boolean checkSpace(String userNumber) {
        return userNumber.contains(" ");
    }

    public boolean checkNumber(String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
