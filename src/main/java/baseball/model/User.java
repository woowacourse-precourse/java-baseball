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

    // User validator 메서드들
    /**
     * @param userNumber
     * @return 중복된 숫자가 있으면 true, 없으면 false return
     */
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

}
