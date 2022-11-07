package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START_MESSAGE);
        Game game = new Game();
        game.init();
    }
}
