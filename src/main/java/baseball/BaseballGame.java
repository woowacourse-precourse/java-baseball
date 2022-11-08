package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.Constants.GAME_INPUT_LENGTH;
import baseball.Constants.Message;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static String requireUserNumber() {
        System.out.print(Message.INPUT_MSG);
        String userNumber = Console.readLine();
        return userNumber;
    }

    public static String requireRestartNumber() {
        System.out.println(Message.RESTART_MSG);
        String restartNumber = Console.readLine();
        return restartNumber;
    }

    public static void exceptionZeroNumber(String Input) {
        for (int i = 0; i < Input.length(); i++) {
            if (Input.charAt(i) == '0') {
                throw new IllegalArgumentException(Message.ERROR_MSG);
            }
        }
    }

    public static void exceptionThreeNumber(String Input) {
        if (Input.length() != GAME_INPUT_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_MSG);
        }
    }

    public static void exceptionNoNumber(String Input) {
        for (int i = 0; i < Input.length(); i++) {
            char temp = Input.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new IllegalArgumentException(Message.ERROR_MSG);
            }
        }
    }

    public static void exceptionSameNumber(String Input) {
        List<Character> user = new ArrayList<>();
        for (int i = 0; i < Input.length(); i++) {
            if (user.contains(Input.charAt(i))) {
                throw new IllegalArgumentException(Message.ERROR_MSG);
            }
            user.add(Input.charAt(i));
        }
    }

}
