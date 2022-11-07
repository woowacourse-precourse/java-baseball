package baseball;

import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final Validator validator = new Validator();

    private InputView() {

    }

    public static String inputBallNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!validator.isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String inputGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!validator.isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
