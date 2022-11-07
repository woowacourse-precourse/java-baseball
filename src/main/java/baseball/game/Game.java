package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void start() {
        Game game = new Game();
    }

    private String getInputUserNumber() {
        return Console.readLine();
    }
}
