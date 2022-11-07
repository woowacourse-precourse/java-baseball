package baseball.domain;

import baseball.exception.UserException;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {
        userInputNumberList = new ArrayList<>();
    }

    private static UserException userException = new UserException();

    public static List<Integer> userInputNumberList;

    public static List<Integer> getUserInputNumberList() {
        return userInputNumberList;
    }
}
