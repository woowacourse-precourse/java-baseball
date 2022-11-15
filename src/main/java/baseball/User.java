package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;


public class User {

    private User() {

    }

    public static List getUserNum() {
        String userAns = Console.readLine();
        validateInt(userAns);
        validateLen(userAns);
        List<String> userAnswers = new ArrayList<>(Arrays.asList(userAns.split("")));
        List<Integer> user = userAnswers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        validateDup(user);
        return user;
    }

    // validate type of input
    public static void validateInt(String userAns) {
        try {
            Integer.valueOf(userAns);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    // validate input length
    public static void validateLen(String userAns) {
        if (userAns.length() != Application.length) {
            throw new IllegalArgumentException();
        }
    }

    // validate duplicate of input
    public static void validateDup(List user) {
        Set<Integer> set = new HashSet<>(user);
        if (set.size() != user.size()) {
            throw new IllegalArgumentException();
        }
    }
}
