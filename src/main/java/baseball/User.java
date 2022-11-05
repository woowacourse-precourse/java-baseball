package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int DIGIT_NUMBER = 3;

    public static List<Integer> userNumber() {
        List<Integer> userNumber = new ArrayList<>();

        System.out.print(GameMessage.input);
        String inputStringNumber = Console.readLine();
        userException(inputStringNumber);

        for (int userIndex = 0; userIndex < inputStringNumber.length(); userIndex++) {
            int number = inputStringNumber.charAt(userIndex) - '0';

            if (!userNumber.contains(number)) {
                userNumber.add(number);
            }
        }

        return userNumber;
    }

    public static void userException(String user) {
        if (user.length() != DIGIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
