package baseball;

import constant.Message;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        Message.showGameStartMessage();
        baseballGame.run();
    }
}
