package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.\n";
    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";

    public void playGame() {
        System.out.print(GAME_START_COMMENT);
        String userInput = getUserInput();
    }

    public String getUserInput() {
        System.out.print(NUMBER_INPUT_COMMENT);
        return Console.readLine();
    }
}
