package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNumberList = new ArrayList<>();
    private static final int MAX_NUMBER_SIZE = 3;

    public void setUserNumber(String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {

            int eachNumver = Integer.parseInt(String.valueOf(userNumber.charAt(i)));

            if (userNumberList.size() != MAX_NUMBER_SIZE) {
                userNumberList.add(eachNumver);
            } else {
                userNumberList.set(i, eachNumver);
            }
        }
    }



    public List<Integer> getUserNumberList() {
        return userNumberList;
    }
}
