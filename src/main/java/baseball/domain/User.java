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

    public static void setUserInputNumberList() {
        String inputNumber = Console.readLine();

        userException.checkUserExceptions(inputNumber);
        initNumberList();
        for (int i = 0; i < Constant.MAX_NUMBER_SIZE; i++) {
            userInputNumberList.add(inputNumber.charAt(i) - '0');
        }
    }

    public static void initNumberList() {
        userInputNumberList = new ArrayList<>();
    }

}
