package baseball;

import baseball.controller.Game;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        Game game = new Game();
        game.play();
    }
}
