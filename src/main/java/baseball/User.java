package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static String userInput;

    public static void setUserInput(String userInput) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        User.userInput = input;
    }
}
