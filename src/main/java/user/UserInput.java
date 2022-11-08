package user;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static final int USER_INPUT_LENGTH = 3;


    public static List<Integer> getUserInput() {
        List<Integer> userInputList = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (userInput.length() != USER_INPUT_LENGTH) {
            //System.out.println("3개의 숫자를 입력해주세요!");
            throw new IllegalArgumentException();
        }
        final String REGEX = "[0-9]+";
        if (!userInput.matches(REGEX)) {
            //System.out.println("숫자만 입력해 주세요!");
            throw new IllegalArgumentException();
        }
        userInputList = changeUserInputToList(userInput);

        return userInputList;
    }

    public static List<Integer> changeUserInputToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < USER_INPUT_LENGTH; i++) {
            int number = userInput.charAt(i) - '0';
            userInputList.add(number);
        }
        return userInputList;
    }

    public static boolean isRetry(String userInput) {
        return userInput.equals("1");
    }

}
