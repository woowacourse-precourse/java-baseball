package baseball;

import baseball.controller.BaseballGame;
import baseball.controller.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new BaseballGame();
        boolean playing = true;
        while (playing) {
            game.run();
            playing = game.replay();
        }
        System.out.println("게임 종료");
    }
}
