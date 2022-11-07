package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startMessage() {
        System.out.printf(START_MESSAGE+"\n");
    }

    public static String gameMessage() {
        System.out.print(GAME_MESSAGE);
        return Console.readLine();
    }

    public static String endMessage() {
        System.out.print(END_MESSAGE+"\n");
        return Console.readLine();
    }
}