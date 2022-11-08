package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTROLL_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String RESTART_GAME_INPUT = "1";
    public static final String EXIT_GAME_INPUT = "2";

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String controllGame() {
        System.out.println(CONTROLL_GAME_MESSAGE);
        return Console.readLine();
    }
}
