package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int DIGIT_NUMBER = 3;

    public static String number() {
        String userNumber = "";

        System.out.print(GameMessage.input);
        String inputStringNumber = Console.readLine();
        userException(inputStringNumber);

        for (int userIndex = 0; userIndex < inputStringNumber.length(); userIndex++) {
            String number = inputStringNumber.charAt(userIndex)+"";

            if (!userNumber.contains(number)) {
                userNumber += number;
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
