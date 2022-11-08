package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constants.END_NUM;
import static baseball.Constants.GAME_INPUT_LENGTH;
import static baseball.Constants.RESTART_INPUT_LENGTH;
import static baseball.Constants.RESTART_NUM;

import baseball.Constants.Message;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static int checkSame(List<Integer> computer, List<Integer> user) {
        int ballNum = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                ballNum += 1;
            }
        }
        return ballNum;
    }

    public static int checkStrike(List<Integer> computer, List<Integer> user) {
        int strikeNum = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeNum += 1;
            }
        }
        return strikeNum;
    }

    public static List<Integer> initComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GAME_INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> initUserNumber() {
        String userInput = requireUserNumber();
        exceptionUserNumber(userInput);
        List<Integer> userNumber = new ArrayList<>();
        String[] splitStr = userInput.split("");
        for (String s : splitStr) {
            userNumber.add(Integer.valueOf(s));
        }
        return userNumber;
    }

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

    public static void exceptionUserNumber(String Input) {
        exceptionThreeNumber(Input);
        exceptionZeroNumber(Input);
        exceptionNoNumber(Input);
        exceptionSameNumber(Input);
    }

    public static void exceptionRestartNumber(String Input) {
        exceptionOneNumber(Input);
        exceptionNoNumber(Input);
        exceptionNotRestartNumber(Input);
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

    public static void exceptionOneNumber(String Input) {
        if (Input.length() != RESTART_INPUT_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_MSG);
        }
    }

    public static void exceptionNotRestartNumber(String Input) {
        if (!Input.equals(Integer.toString(RESTART_NUM)) && !Input.equals(Integer.toString(END_NUM))) {
            throw new IllegalArgumentException(Message.ERROR_MSG);
        }
    }
}
