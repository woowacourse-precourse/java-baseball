package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static baseball.InputException.userInputRestartValidationCheck;
import static baseball.InputException.userInputValidationCheck;
import static baseball.Utill.stringToList;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SELECT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> getUserInput() {
        System.out.printf(INPUT_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        userInputValidationCheck(userInput);
        return stringToList(userInput);
    }

    public static String restartGame() {
        System.out.println(SELECT_RESTART_MESSAGE);
        String userInput = Console.readLine();
        userInputRestartValidationCheck(userInput);
        return userInput;
    }
}
