package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BaseballGame.play();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
