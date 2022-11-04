package baseball;


import baseball.exception.NumberExceptionUtils;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        String playerNum = getPlayerInputNum();
    }

    public static String getPlayerInputNum() {
        String input = Console.readLine();
        checkValidInput(input);
        return input;
    }

    private static void checkValidInput(String input) {
        NumberExceptionUtils.isPositiveDigits(input);
        NumberExceptionUtils.isThreeDigits(input);
        NumberExceptionUtils.isNotDuplicateNumber(input);
    }
}
