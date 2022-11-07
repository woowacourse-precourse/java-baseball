package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame();
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame() {
        do {
            GameFormatter.gameStartMessage();
            GameFormatter.gameInputMessage();
            GameFormatter.gameEndMessage();
        } while (true);
    }
}
