package baseball.view;

import baseball.model.Umpire;

public class GameScreen {
    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String PLAYER_INPUT = "숫자를 입력해주세요 : ";

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printUserInput() {
        System.out.print(PLAYER_INPUT);
    }

    public static void printGameResult(Umpire umpire) {
        System.out.println(umpire.decision());
    }
}
