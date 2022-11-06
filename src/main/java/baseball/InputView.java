package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.\n";
    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    
    public static void printGameStart() {
        System.out.println(GAME_START_COMMENT);
    }

    public static String getUserInput() {
        System.out.print(NUMBER_INPUT_COMMENT);
        return Console.readLine();
    }
}
