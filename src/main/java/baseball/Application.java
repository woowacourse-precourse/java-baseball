package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        while (true) {
            game.startGame();
            game.playGame();
            if(game.checkFinish()) {
                break;
            }
        }
    }
}