package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class User {
    final static int NUMBER_DIGIT = 3;
    final static int RESTART_GAME = 1;
    final static int QUIT_GAME = 2;

    private User(){
    }

    public static List userInput() throws IllegalArgumentException{
        System.out.print(Message.INPUT_NUMBER);
        String str = Console.readLine();
        if (validateUserInput(str)) {
            throw new IllegalArgumentException();
        }
        return StringToNumberList(str);
    }
    private static List StringToNumberList(String str) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i) - '0');
        }
        return result;
    }

    private static boolean validateUserInput(String str) {
        StringBuilder regex = new StringBuilder();
        regex.append("[1-9]{").append(NUMBER_DIGIT).append("}");

        if (!Pattern.matches(regex.toString(), str)) {
            return true;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i + 1).contains(str.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    }
    public static boolean restart() {
        int input = Integer.parseInt(Console.readLine());
        return input == RESTART_GAME;
    }
}