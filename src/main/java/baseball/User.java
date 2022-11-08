package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> user;

    public List<Integer> inputNumbers(String userNum) {
        user = new ArrayList<>();
        String[] nums = userNum.split("");
        lengthInCorrectException(nums.length);

        for (String num : nums) {
            int numInt = isNumberic(num);
            isContainNumberException(user, numInt);
            user.add(numInt);
        }
        return user;
    }

    public void lengthInCorrectException(int length) {
        if (length != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void isContainNumberException(List<Integer> nums, int num) {
        if (nums.contains(num)) {
            throw new IllegalArgumentException();
        }
    }

    public int isNumberic(String num) throws IllegalArgumentException {
        return Integer.parseInt(num);
    }
}
