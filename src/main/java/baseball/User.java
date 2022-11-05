package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class User {

    private User() {

    }

    public static List getUserNum() {
            String userStr = Console.readLine();
            validateInt(userStr);
            validateLen(userStr);
            List<String> user = new ArrayList<>(Arrays.asList(userStr.split("")));
            validateDup(user);
            return user;
    }

    // validate type of input
    public static void validateInt(String userStr) {
        try {
            Integer.valueOf(userStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    // validate input length
    public static void validateLen(String userStr) {
        if (userStr.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    // validate duplicate of input
    public static void validateDup(List user) {
        Set<String> set = new HashSet<>(user);
        if (set.size() != user.size()) {
            throw new IllegalArgumentException();
        }
    }

}
