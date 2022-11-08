package baseball.views;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final int MAX_LENGTH = 3;
    private static final int END_GAME_COMMAND_LENGTH = 1;
    private static final String NEW_GAME = "1";
    private static final String END_GAME = "2";
    private Input(){}

    public static String input() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        InputValidator.validateUserInput(number, MAX_LENGTH);

        return number;
    }

    public static int askContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " +
                NEW_GAME + ", 종료하려면 " +
                END_GAME + "를 입력하세요.");

        String number = Console.readLine();

        InputValidator.validateEndGameInput(number, END_GAME_COMMAND_LENGTH);

        return Integer.parseInt(number);
    }
}
