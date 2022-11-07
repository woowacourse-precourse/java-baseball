package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputUtil {

    private UserInputUtil() {
    }

    public static boolean checkProgress() {
        String input = Console.readLine();

        int number = toInteger(input);

        if (number == 1) {
            return true;
        } else if (number == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
    private static int toInteger(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
